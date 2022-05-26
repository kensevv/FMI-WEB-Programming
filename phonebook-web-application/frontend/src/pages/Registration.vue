<template>
  <div class="bg-light-blue window-height window-width row justify-center items-center">
    <div class="column">
      <div class="row">
        <h5 class="text-h5 text-white q-my-md">Phonebook - WEB FMI</h5>
      </div>
      <div class="row">
        <q-card square bordered class="q-pa-lg shadow-1">
          <q-form ref="registerForm" class="q-gutter-md" @submit="register()">
            <q-card-section>
              <q-input square filled v-model="email" type="email" label="email"/>
              <br>
                <q-input
                    square
                    filled
                    v-model="firstName"
                    type="text"
                    label="first name"
                    :rules="[ val => val && val.length > 0 || 'Please enter first name']" />
              <br>
                <q-input
                    square
                    filled
                    v-model="lastName"
                    type="text"
                    label="last name"
                    :rules="[val => val && val.length > 0 || 'Please enter last name']" />
              <br>
                <q-input
                    square
                    filled
                    v-model="username"
                    type="text"
                    label="username"
                    :rules="[ val => val && val.length > 3 || 'Please enter valid username (3 or more characters)']"
                     />
              <br>
                <q-input
                    square
                    filled
                    v-model="password"
                    type="password"
                    label="password"
                    :rules="[val => val && val.length > 6 || 'Password must 6 or more characters']" />
            </q-card-section>
            <q-card-actions class="q-px-md">
              <q-btn type="submit" unelevated color="light-green-7" size="lg" class="full-width" label="Register"/>
            </q-card-actions>
            <div class="row q-pa-none">
              <q-item class="q-pr-none text-grey-6">Already have an account?
                <span clickable @click="goToLogInPage()" class="text-primary q-pl-xs">Log In</span>
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


const goToLogInPage = () => {
    toRegister.value=false;
    console.log('login')
}

const register = () => {
    console.log('submit')
    const newUser : User = {userId : Math.floor(Math.random() * 100000 + 100), email : email.value, username : username.value, firstName : firstName.value, lastName : lastName.value}
    mockedUsers.push(newUser)
    currentUser.value = newUser
    toRegister.value = false;
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