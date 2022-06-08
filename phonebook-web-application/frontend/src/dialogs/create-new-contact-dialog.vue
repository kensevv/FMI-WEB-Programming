<template>
  <q-dialog ref="dialogRef" @hide="onDialogHide">
    <q-card class="q-dialog-plugin">
      <q-card-section class="dialog-header">
        <div class="text-h6">Create new contact</div>
        <q-btn v-close-popup dense flat icon="close" round/>
      </q-card-section>
      <q-card-section>
        <q-form class="q-gutter-md" @submit="submit">

          <q-file accept=".jpg, image/*" filled bottom-slots v-model="contactItem.photo" label="Photo" counter
                  max-files="1">
            <template v-slot:before>
              <q-icon v-if="!contactItem.photo" name="person" size="lg"></q-icon>
              <img v-else alt="Avatar" :src="photoPreview" class="image-preview">
            </template>
            <template v-slot:append>
              <q-icon v-if="contactItem.photo !== null" name="close" @click.stop="contactItem.photo = null"
                      class="cursor-pointer"/>
              <q-icon name="create_new_folder" @click.stop/>
            </template>
            <template v-slot:hint>
              .jpg, image/*
            </template>
          </q-file>

          <q-input v-model="contactItem.name" dense filled label="Name"/>
          <q-input v-model="contactItem.email" type="email" dense filled label="Email"/>

          <div>Address:</div>
          <div>
            <q-input v-model="contactItem.address.country" dense filled label="Country"/>
            <q-input v-model="contactItem.address.city" dense filled label="City"/>
            <q-input v-model="contactItem.address.street" dense filled label="Street"/>
            <q-input v-model="contactItem.address.zipCode" dense filled label="Zip Code"/>
          </div>

          <div>Phone numbers:</div>

          <div v-for="phoneNumber in contactItem.phoneNumbers">
            <div class="row">
              <div class="col">
                <phone-number-component :phone-number="phoneNumber"/>
              </div>
              <div class="col-1" style="margin-top: 5px">
                <q-btn color="negative"
                       flat
                       icon="delete"
                       round
                       size="s"
                       @click="deletePhone(phoneNumber)"/>
              </div>
            </div>
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
import {ref, watch} from "vue";
import {Contact} from "../models/Contact";
import PhoneNumberComponent from "../components/phone-number-component.vue";
import {Address} from "../models/Address";
import {PhoneNumber} from "../models/PhoneNumber";

const {dialogRef, onDialogHide, onDialogOK, onDialogCancel} = useDialogPluginComponent()

defineEmits([...useDialogPluginComponent.emits])

const contactItem = ref<Contact>({
  address: <Address>{}, contactId: undefined, email: "", name: "", phoneNumbers: [], photo: undefined
})

const photoPreview = ref(null)
watch(() => contactItem.value.photo, () => photoPreview.value = URL.createObjectURL(contactItem.value.photo))

let id = 0
const addNewPhoneNumber = () => {
  contactItem.value.phoneNumbers.push({phoneNumber: null, phoneNumberId: id++, type: undefined})
}

const submit = async () => onDialogOK(contactItem.value)

const deletePhone = (phoneNumber: PhoneNumber) => {
  contactItem.value.phoneNumbers = contactItem.value.phoneNumbers.filter(number => number.phoneNumberId != phoneNumber.phoneNumberId)
}

</script>
<style scoped>

.image-preview {
  margin-top: 20px;
  width: 90px;
  height: 90px;
  border-radius: 50%;
}

.dialog-header {
  display: flex;
  justify-content: space-between;
}
</style>
