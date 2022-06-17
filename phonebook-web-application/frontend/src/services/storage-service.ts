import {User} from "../models/User";
import {ref} from "vue";
import {useSessionStorage} from "@vueuse/core";


export const storeUser = (user: User) => {
    useSessionStorage('phonebookUser', user);
    currentUser.value = user
}
export const clearUserStorage = () => {
    currentUser.value = null
    sessionStorage.clear();
}
export const getCurrentUser = (): User => JSON.parse(sessionStorage.getItem('phonebookUser'))
export const userIsLoggedIn = (): boolean => sessionStorage.getItem('phonebookUser') != null


export const currentUser = ref<User | null>(getCurrentUser())
export const toRegister = ref<boolean>(false)