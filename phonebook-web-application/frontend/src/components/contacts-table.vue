<template>
  <q-page class="q-layout-padding">
    <div class="row">
      <div class="col-1"/>
      <div class="col">
        <q-table
            :columns="columns"
            :pagination="{rowsPerPage: 0}"
            :rows="props.contacts"
            dense
            hide-pagination
            style="height: fit-content"
            title="Contacts"
            virtual-scroll
        >
          <template v-slot:body-cell-photo="props">
            <q-td>
              <q-avatar color="primary" text-color="white" icon="person"/>
            </q-td>
          </template>
          <template v-slot:body-cell-edit="props">
            <q-td>
              <q-btn color="negative"
                     flat
                     icon="delete"
                     round
                     size="s"
                     @click="deleteContact(props.row)"/>
            </q-td>
          </template>
          <template v-slot:top-right>
            <q-btn color="secondary" icon="add_circle_outline" label="new" @click="addNewContact()"/>
          </template>
        </q-table>
      </div>
      <div class="col-1"/>
    </div>
  </q-page>
</template>

<script lang="ts" setup>
import {Contact} from "../models/Contact";
import {Address} from "../models/Address";
import {currentUser} from "../services/storage-service";
import {useQuasar} from "quasar";
import CreateNewContactDialog from "../dialogs/create-new-contact-dialog.vue";

const quasar = useQuasar()

const props = defineProps<{
  contacts: Contact[]
}>()

const deleteContact = (contactToDelete: Contact) =>
    currentUser.value.contacts = currentUser.value?.contacts?.filter(contact => contact.contactId != contactToDelete.contactId)

const addNewContact = () => {
  quasar.dialog({
    component: CreateNewContactDialog,
  }).onOk(async (newContact: Contact) => {
    currentUser.value.contacts.push(newContact)
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

</style>