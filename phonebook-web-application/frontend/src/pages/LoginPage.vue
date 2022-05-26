<template>
  <div class="bg-light-blue window-height window-width row justify-center items-center">
    <div class="column">
      <div class="row">
        <h5 class="text-h5 text-white q-my-md">Phonebook - WEB FMI</h5>
      </div>
      <div class="row">
        <q-card square bordered class="q-pa-lg shadow-1">
          <q-form class="q-gutter-md" @submit="login()">
            <q-card-section>
              <q-input square filled v-model="username" type="username" label="username"/>
              <br>
              <q-input square filled v-model="password" type="password" label="password"/>
            </q-card-section>
            <q-card-actions class="q-px-md">
              <q-btn type="submit" unelevated color="light-green-7" size="lg" class="full-width" label="Login"/>
            </q-card-actions>
          </q-form>
          <q-card-section class="text-center q-pa-none">
            <p class="text-grey-6">Not reigistered? Create an Account</p>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import {mockedUsers} from "../services/mocked-data-service";
import {User} from "../models/User";
import {currentUser} from "../services/storage-service";

const username = ref('')
const password = ref('')

const login = () => {
  const user: User | undefined = mockedUsers.find(user => user.username === username.value);
  if (user) {
    currentUser.value = user
  }
}

</script>

<style>
.q-card {
  width: 360px;
}
</style>