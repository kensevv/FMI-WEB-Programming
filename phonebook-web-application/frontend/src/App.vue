<template>
  <LoginPage v-if="!currentUser"/>
  <Home v-else/>
</template>


<script setup lang="ts">
import Home from "./pages/Home.vue";
import LoginPage from "./pages/LoginPage.vue";
import {currentUser} from "./services/storage-service";</script>

<style scoped>
</style>
