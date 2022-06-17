<template>
  <suspense>
    <LoginPage v-if="!currentUser && !toRegister"/>
    <Registration v-else-if="!currentUser && toRegister"/>
    <Home v-else/>
  </suspense>
</template>


<script setup lang="ts">
import Home from "./pages/Home.vue";
import LoginPage from "./pages/LoginPage.vue";
import {currentUser, toRegister} from "./services/storage-service";
import Registration from "./pages/RegistrationPage.vue";</script>

<style scoped>
</style>
