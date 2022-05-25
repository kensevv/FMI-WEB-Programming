<template>
  <q-layout view="hHh lpR fFf">
    <q-header elevated class="bg-primary text-white">
      <q-toolbar>
        <q-btn flat icon="home" label="Home"/>
        <q-btn flat icon="contact_phone" label="Contacts"/>
        <q-space/>
        <q-toolbar-title shrink>
          <q-avatar style="width: 50px; height: 50px;">
            <img src="../assets/phonebook.ico">
          </q-avatar>
          Phonebook Project
        </q-toolbar-title>
        <q-space/>
        <!--        MOCKED USER SETTINGS -->
        <q-btn-dropdown label="USERNAME" flat icon="person">
          <div>
            <q-list>
              <q-item v-ripple>
                <q-item-section>
                  <q-item-label caption>First name</q-item-label>
                  <q-item-label class="user-detail"> Kenan</q-item-label>
                </q-item-section>
              </q-item>
              <q-item v-ripple>
                <q-item-section>
                  <q-item-label caption>Last name</q-item-label>
                  <q-item-label class="user-detail">Yusein</q-item-label>
                </q-item-section>
              </q-item>
              <q-item v-ripple>
                <q-item-section>
                  <q-item-label caption>E-mail</q-item-label>
                  <q-item-label class="user-detail">kensev2000@gmail.com</q-item-label>
                </q-item-section>
              </q-item>
              <q-item v-ripple>
                <q-item-section>
                  <q-item-label caption>Contacts count</q-item-label>
                  <q-item-label class="user-detail">50</q-item-label>
                </q-item-section>
              </q-item>
            </q-list>
          </div>
          <q-separator/>
          <q-item v-close-popup clickable @click="onLogoutClick">
            <q-item-section avatar>
              <q-avatar color="red" icon="logout" text-color="white"/>
            </q-item-section>
            <q-item-section>
              <q-item-label>Logout</q-item-label>
            </q-item-section>
          </q-item>
        </q-btn-dropdown>
      </q-toolbar>
    </q-header>

    <q-page-container>
      <HelloWorld></HelloWorld>
    </q-page-container>

    <q-footer elevated class="bg-grey-7 text-white">
      <q-toolbar>
        <q-toolbar-title shrink>
          FMI WEB PROGRAMMING
        </q-toolbar-title>
        <q-space/>
        Kenan, Evelina, Ivo, Ivan.
        <br>
        @All rights reserved 2022.
      </q-toolbar>
    </q-footer>
  </q-layout>
</template>

<script lang="ts" setup>

import HelloWorld from "../components/HelloWorld.vue";

const onLogoutClick = () => console.log("LOGGED OUT!")

</script>

<style scoped>
.user-detail {
  color: #1565C0;
}
</style>