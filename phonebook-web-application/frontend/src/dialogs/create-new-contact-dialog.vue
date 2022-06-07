<template>
  <q-dialog ref="dialogRef" @hide="onDialogHide">
    <q-card class="q-dialog-plugin">
      <q-card-section class="dialog-header">
        <div class="text-h6">Create new contact</div>
        <q-btn v-close-popup dense flat icon="close" round/>
      </q-card-section>
      <q-card-section>
        <q-form class="q-gutter-md" @submit="submit">
          <q-file filled bottom-slots v-model="model" label="Photo" counter max-files="12">
            <template v-slot:before>
              <q-icon name="person" size="lg"></q-icon>
            </template>
            <template v-slot:append>
              <q-icon v-if="model !== null" name="close" @click.stop="model = null" class="cursor-pointer"/>
              <q-icon name="create_new_folder" @click.stop/>
            </template>
            <template v-slot:hint>
              Pick a photo for the new contact
            </template>
          </q-file>

          <q-input v-model="contactItem.name" dense filled label="Name"/>
          <q-input v-model="contactItem.email" type="email" dense filled label="Email"/>

          <div>Phone numbers:</div>
          <div v-for="phoneNumber in contactItem.phoneNumbers">
            <phone-number-component :phone-number="phoneNumber"></phone-number-component>
          </div>
          <q-btn color="secondary" icon="add_circle_outline" flat label="Add phone" @click="addNewPhoneNumber()"/>


          <q-card-actions align="right">
            <q-btn color="primary" label="Submit" type="update"/>
            <q-btn class="q-ml-sm" color="primary" flat label="Cancel" @click="onDialogCancel"/>
          </q-card-actions>
        </q-form>
      </q-card-section>
    </q-card>
  </q-dialog>
</template>
<script lang="ts" setup>
import {useDialogPluginComponent} from 'quasar'
import {ref} from "vue";
import {Contact} from "../models/Contact";
import PhoneNumberComponent from "../components/phone-number-component.vue";
import {Address} from "../models/Address";
import {PhoneType} from "../models/PhoneType";

const {dialogRef, onDialogHide, onDialogOK, onDialogCancel} = useDialogPluginComponent()

defineEmits([...useDialogPluginComponent.emits])

const contactItem = ref<Contact>({
  address: <Address>{}, contactId: undefined, email: "", name: "", phoneNumbers: [], photo: undefined
})

const addNewPhoneNumber = () => {
  contactItem.value.phoneNumbers.push({phoneNumber: null, phoneNumberId: null, type: undefined})
}

const submit = async () => onDialogOK(contactItem.value)

</script>
<style scoped>
.dialog-header {
  display: flex;
  justify-content: space-between;
}
</style>
