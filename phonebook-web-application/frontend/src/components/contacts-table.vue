<template>
  <q-page class="q-layout-padding">
    <div class="row">
      <div class="col-2">
        <span>Table</span>
        <q-toggle v-model="gridMode"></q-toggle>
        <span>Grid</span>
      </div>

      <div class="col">
        <q-table
            row-key="contactUuid"
            :filter="filter"
            :columns="columns"
            :pagination="{rowsPerPage: 0}"
            :rows="contacts"
            dense
            selection="multiple"
            v-model:selected="selected"
            hide-pagination
            :grid="gridMode"
            style="height: fit-content"
            virtual-scroll
        >
          <template v-if="!gridMode" v-slot:body-cell-photo="props">
            <q-td>
              <img v-if="props.value" alt="Avatar" :src="props.value" class="image-preview">
              <q-avatar v-else color="primary" text-color="white" icon="person"/>
            </q-td>
          </template>
          <template v-slot:bottom>
            <q-btn :disable="selected.length <= 1"
                   flat
                   color="primary"
                   icon="plagiarism"
                   label="MERGE SELECTED CONTACTS"
                   @click="mergeSelectedContacts"/>
          </template>
          <template v-if="!gridMode" v-slot:body-cell-edit="props">
            <q-td>
              <q-btn color="primary"
                     flat
                     icon="edit"
                     round
                     size="s"
                     @click="editContact(props.row)"/>
              <q-btn color="negative"
                     flat
                     icon="delete"
                     round
                     size="s"
                     @click="deleteContact(props.row)"/>
            </q-td>
          </template>
          <template v-if="gridMode" v-slot:item="props">
            <div
                :style="props.selected ? 'transform: scale(0.95);' : ''"
                class="q-pa-xs col-xs-12 col-sm-6 col-md-4 col-lg-3 grid-style-transition"
            >
              <q-card :class="props.selected ? 'bg-grey-2' : ''">
                <q-card-section>
                  <div class="row">
                    <img v-if="props.cols.find(col => col.name === 'photo').value"
                         :src="props.cols.find(col => col.name === 'photo').value" alt="Avatar"
                         class="image-preview">
                    <q-avatar v-else color="primary" icon="person" text-color="white"/>
                    <q-space/>
                    <q-btn color="primary"
                           flat
                           icon="edit"
                           round
                           size="s"
                           @click="editContact(props.row)"/>
                    <q-btn color="negative"
                           flat
                           icon="delete"
                           round
                           size="s"
                           @click="deleteContact(props.row)"/>
                  </div>
                </q-card-section>
                <q-separator/>
                <q-list dense>
                  <q-item v-for="col in props.cols.filter(col => col.name !== 'photo')" :key="col.name">
                    <q-item-section>
                      <q-item-label caption>{{ col.label }}</q-item-label>
                      <q-item-label>{{ col.value }}</q-item-label>
                    </q-item-section>
                  </q-item>
                </q-list>
              </q-card>
            </div>
          </template>
          <template v-slot:top-left>
            <q-btn color="secondary" flat icon="add_circle_outline" label="add new contact" @click="addNewContact()"/>
          </template>
          <template v-slot:top-right>
            <q-input v-model="filter" debounce="300" dense placeholder="Search">
              <template v-slot:append>
                <q-icon name="search"/>
              </template>
            </q-input>
          </template>
        </q-table>
      </div>
      <div class="col-2"/>
    </div>
  </q-page>
</template>

<script lang="ts" setup>
import {Contact} from "../models/Contact";
import {Address} from "../models/Address";
import {useQuasar} from "quasar";
import CreateNewContactDialog from "../dialogs/create-new-contact-dialog.vue";
import EditContactDialog from "../dialogs/edit-contact-dialog.vue";
import {ref} from "vue";
import {
  addNewContactToCurrentUser,
  deleteContactById,
  getCurrentUserContacts,
  updateContact
} from "../services/request-service";
import {v4 as uuidv4} from "uuid";

const quasar = useQuasar()

const contacts = ref(await getCurrentUserContacts())

const deleteContact = async (contactToDelete: Contact) => {
  await deleteContactById(contactToDelete.contactUuid)
  contacts.value = contacts.value.filter(contact => contact.contactUuid != contactToDelete.contactUuid);
}

const addNewContact = () => {
  quasar.dialog({
    component: CreateNewContactDialog,
  }).onOk(async (newContact: Contact) => {
    await addNewContactToCurrentUser(newContact)
    contacts.value.push(newContact)
  })

}
const editContact = (contactToEdit: Contact) => {
  quasar.dialog({
    component: EditContactDialog,
    componentProps: {
      'contact': {...contactToEdit},
    }
  }).onOk(async (editedContact: Contact) => {
    await updateContact(editedContact)
    contacts.value = contacts.value.map(contact => {
      if (contact.contactUuid == editedContact.contactUuid) {
        return editedContact
      } else {
        return contact
      }
    })
  })
}


const filter = ref('')

const gridMode = ref(true)

const selected = ref<Contact[]>([])

const mergeSelectedContacts = () => {
  const initialContact: Contact = selected.value[0]
  quasar.dialog({
    component: EditContactDialog,
    componentProps: {
      'contact': {
        ...initialContact,
        contactUuid: uuidv4().toString(),
        name: '',
        email: '',
        address: {...initialContact.address, addressUuid: uuidv4().toString()},
        phoneNumbers: selected.value.map(contact => contact.phoneNumbers).flat().map(phoneNumber => ({
          ...phoneNumber,
          phoneNumberUuid: uuidv4().toString()
        }))
      },
    }
  }).onOk(async (editedContact: Contact) => {
    await addNewContactToCurrentUser(editedContact)
    selected.value.forEach(async contact => await deleteContactById(contact.contactUuid))
    contacts.value = contacts.value.filter(contact => !selected.value.map(con => con.contactUuid).includes(contact.contactUuid))
    contacts.value.push(editedContact)
  })
}

const columns = [
  {
    name: 'photo',
    label: 'Photo',
    field: (row: Contact) => row.photo,
    align: 'left'
  },
  {
    name: 'name',
    label: 'Name',
    field: (row: Contact) => row.name,
    align: 'left'
  },
  {
    name: 'email',
    label: 'Email',
    field: (row: Contact) => row.email,
    align: 'left'
  },
  {
    name: 'address',
    label: 'Address',
    field: (row: Contact) => row.address ? `${row.address.street}, ${row.address.city}, ${row.address.zipCode}, ${row.address.country}` : '',
    align: 'left'
  },
  {
    name: 'phoneNumbers',
    label: 'Phone Numbers',
    field: (row: Contact) => {
      let result: string = ''
      row.phoneNumbers?.forEach(number => {
        result = result + `${number.type} - ${number.phoneNumber}; `
      })
      return result;
    },
    align: 'left'
  },
  {name: "edit"},
]
</script>

<style scoped>
.image-preview {
  width: 70px;
  height: 70px;
  border-radius: 50%;
}
</style>