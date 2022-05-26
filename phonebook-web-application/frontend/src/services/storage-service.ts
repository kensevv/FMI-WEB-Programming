import {User} from "../models/User";
import {ref} from "vue";

export const currentUser = ref<User | null>(null)
export const toRegister = ref<boolean | null>(false)