<template>
  <div class="bg-light-blue window-height window-width row justify-center items-center">
    <div class="column">
      <div class="row">
        <h4 class="text-h4 text-white q-my-md title">Phonebook</h4>
      </div>
      <div class="row">
        <q-card square bordered class="q-pa-lg shadow-1">
          <q-form class="q-gutter-md" @submit="register()">
            <q-card-section>
              <q-input square filled v-model="email" type="email" label="Email"
                       :rules="[ val => val && val.length > 0 || 'Please enter email']"/>
              <q-input
                  square
                  filled
                  v-model="firstName"
                  type="text"
                  label="First name"
                  :rules="[ val => val && val.length > 0 || 'Please enter first name']"/>
              <q-input
                  square
                  filled
                  v-model="lastName"
                  type="text"
                  label="Last name"
                  :rules="[val => val && val.length > 0 || 'Please enter last name']"/>
              <q-input
                  square
                  filled
                  v-model="username"
                  type="text"
                  label="Username"
                  :rules="[ val => val && val.length > 3 || 'Please enter valid username (3 or more characters)']"
              />
              <q-input
                  square
                  filled
                  v-model="password"
                  type="password"
                  label="Password"
                  :rules="[val => val && val.length > 6 || 'Password must 6 or more characters']"/>
            </q-card-section>
            <q-card-actions class="q-px-md">
              <q-btn type="submit" unelevated color="light-green-7" size="lg" class="full-width" label="Register"/>
            </q-card-actions>
            <div class="row q-pa-none">
              <q-item class="q-pr-none text-grey-6">Already have an account?
                <span @click="goToLogInPage()" class="text-primary q-pl-xs">Log In</span>
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

const email = ref('');
const firstName = ref('')
const lastName = ref('')
const username = ref('')
const password = ref('')

const goToLogInPage = () => toRegister.value = false

const register = () => {
  const newUser: User = {
    userId: Math.floor(Math.random() * 100000 + 100),
    email: email.value,
    username: username.value,
    firstName: firstName.value,
    lastName: lastName.value,
    contacts: []
  }
  mockedUsers.push(newUser)
  currentUser.value = newUser
  toRegister.value = false;
}
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