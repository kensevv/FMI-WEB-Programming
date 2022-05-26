<template>
  <div class="bg-light-blue window-height window-width row justify-center items-center">
    <div class="column">
      <div class="row">
        <h5 class="text-white q-my-md">Phonebook - WEB FMI</h5>
      </div>
      <div class="row">
        <q-card square bordered class="q-pa-lg shadow-1">
          <q-form class="q-gutter-md" @submit="login()">
            <q-card-section>
              <q-input square filled v-model="username" type="text" label="username"/>
              <br>
              <q-input square filled v-model="password" type="password" label="password"/>
            </q-card-section>
            <q-card-actions class="q-px-md">
              <q-btn type="submit" unelevated color="light-green-7" size="lg" class="full-width" label="Login"/>
            </q-card-actions>
            <div class="row q-pa-none">
              <q-item class="q-pr-none text-grey-6">Don't have an account?
                <span clickable @click="goToRegisterPage()" class="text-primary q-pl-xs">Register</span>
              </q-item>
            </div>
          </q-form>
        </q-card>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import {mockedUsers} from "../services/mocked-data-service";
import {User} from "../models/User";
import {currentUser, toRegister} from "../services/storage-service";

const username = ref('')
const password = ref('')

const login = () => {
  const user: User | undefined = mockedUsers.find(user => user.username === username.value);
  if (user) {
    currentUser.value = user
  }
}

const goToRegisterPage = () => {
    toRegister.value = true;
    console.log('register')
}

</script>

<style>
span:hover {
  cursor: pointer;
}
.q-card {
  width: 360px;
}
</style>