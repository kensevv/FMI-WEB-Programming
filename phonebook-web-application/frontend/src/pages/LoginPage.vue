<template>
  <div class="bg-light-blue window-height window-width row justify-center items-center">
    <div class="column">
      <div class="row">
        <h4 class="text-h4 text-white q-my-md title">Phonebook</h4>
      </div>
      <div class="row">
        <q-card square bordered class="q-pa-lg shadow-1">
          <q-form class="q-gutter-md" @submit="login()">
            <q-card-section>
              <q-input square filled v-model="loginRequest.username" type="text" label="username"
                       :rules="[ val => val && val.length > 2 || 'Please enter valid username (3 or more characters)']"/>
              <q-input square filled v-model="loginRequest.password" type="password" label="password"
                       :rules="[ val => val && val.length > 5 || 'Please enter valid password (6 or more characters)']"
              />
              <div class="text-negative"> {{ responseError }}</div>
            </q-card-section>
            <q-card-actions class="q-px-md">
              <q-btn type="submit" unelevated color="light-green-7" size="lg" class="full-width" label="Login"/>
            </q-card-actions>
          </q-form>
          <div class="row q-pa-none">
            <q-item class="q-pr-none text-grey-6">Don't have an account?
              <span @click="goToRegisterPage()" class="text-primary q-pl-xs">Register</span>
            </q-item>
          </div>
        </q-card>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import {LoginRequest} from "../models/Authentication";
import {userLogin} from "../services/request-service";
import {storeUser, toRegister} from "../services/storage-service";

const loginRequest = ref<LoginRequest>(
    {username: '', password: ''}
)

const login = async () =>
    await userLogin(loginRequest.value)
        .then(response => {
          storeUser(response.data)
        }).catch(error => {
          responseError.value = error.response.data;
        })

const responseError = ref('')
const goToRegisterPage = () => toRegister.value = true

</script>

<style scoped>
span:hover {
  cursor: pointer;
}

.q-card {
  width: 360px;
}

.title {
  margin-left: auto;
  margin-right: auto;
}
</style>