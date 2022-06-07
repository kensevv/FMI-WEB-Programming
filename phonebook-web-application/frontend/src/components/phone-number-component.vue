<template>
  <div class="row">
    <div class="col-5 q-pa-sm">
      <q-select v-model="phoneNumber.type"
                :options="Object.keys(PhoneType)"
                dense
                filled
                label="Phone Type"
                :rules="[ val => val !== null || 'Required']"
                options-dense>
      </q-select>
    </div>
    <div class="col q-pa-sm">
      <q-input v-model="phoneNumber.phoneNumber" dense filled label="Number"/>
    </div>
    <div class="col-1" style="margin-top: 5px">
      <q-btn color="negative"
             flat
             icon="delete"
             round
             size="s"
             @click="deletePhone()"/>
    </div>
  </div>
</template>

<script lang="ts" setup>

import {PhoneType} from "../models/PhoneType";

import {PhoneNumber} from "../models/PhoneNumber";

const props = defineProps<{
  phoneNumber?: PhoneNumber,
}>();

const deletePhone = () => {

}
</script>

<style scoped>

</style>