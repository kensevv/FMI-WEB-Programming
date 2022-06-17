import {User} from "../models/User";
import {ref} from "vue";
import {useLocalStorage} from "@vueuse/core";


export const storeUser = (user: User) => {
    useLocalStorage('user', user);
    currentUser.value = user
}
export const clearUserStorage = () => {
    currentUser.value = null
    localStorage.clear();
}
export const getCurrentUser = (): User => JSON.parse(localStorage.getItem('user'))
export const userIsLoggedIn = (): boolean => localStorage.getItem('user') != null


export const currentUser = ref<User | null>(getCurrentUser())
export const toRegister = ref<boolean>(false)