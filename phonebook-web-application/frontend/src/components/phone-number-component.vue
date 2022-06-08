<template>
  <div class="row">
    <div class="col-5 q-pa-sm">
      <q-select v-model="phoneNumber.type"
                :options="Object.keys(PhoneType)"
                dense
                filled
                label="Phone Type"
                options-dense>
      </q-select>
    </div>
    <div class="col q-pa-sm">
      <q-input
          filled
          v-model="phoneNumber.phoneNumber"
          label="Phone"
          mask="(+###) ### - ### - ###"
          fill-mask
      />
    </div>
  </div>
</template>

<script lang="ts" setup>

import {PhoneType} from "../models/PhoneType";

import {PhoneNumber} from "../models/PhoneNumber";

const props = defineProps<{
  phoneNumber?: PhoneNumber,
}>();

</script>

<style scoped>

</style>