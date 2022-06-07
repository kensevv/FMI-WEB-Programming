<template>
  <!--  <q-input v-model="address.addressId" dense filled label="Name"/>-->

</template>

<script lang="ts" setup>

import {Address} from "../models/Address";

const props = defineProps<{
  address?: Address,
}>();

</script>

<style scoped>

</style>