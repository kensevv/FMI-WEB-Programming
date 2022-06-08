import {Contact} from "./Contact"

export interface User {
    userUuid: string
    email: string
    username: string
    firstName: string
    lastName: string
    contacts?: Contact[]
}