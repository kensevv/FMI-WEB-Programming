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
      </q-table>
    </div>
    <div class="col-1"/>
  </div>
  </q-page>
</template>

<script lang="ts" setup>
import {Contact} from "../models/Contact";
import {Address} from "../models/Address";

const props = defineProps<{
  contacts: Contact[]
}>()

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
    field: (row: Contact) => `${row.address.street}, ${row.address.city}, ${row.address.zipCode}, ${row.address.country}`,
    align: 'left'
  },
  {
    name: 'phoneNumbers',
    label: 'Phone Numbers',
    field: (row: Contact) => {
      let result: string = ''
      row.phoneNumbers.forEach(number => {
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