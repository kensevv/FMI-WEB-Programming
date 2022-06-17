import {User} from "../models/User";
import {ref} from "vue";
import {useLocalStorage} from "@vueuse/core";


export const storeUser = (user: User) => {
    useLocalStorage('phonebookUser', user);
    currentUser.value = user
}
export const clearUserStorage = () => {
    currentUser.value = null
    localStorage.clear();
}
export const getCurrentUser = (): User => JSON.parse(localStorage.getItem('phonebookUser'))
export const userIsLoggedIn = (): boolean => localStorage.getItem('phonebookUser') != null


export const currentUser = ref<User | null>(getCurrentUser())
export const toRegister = ref<boolean>(false)