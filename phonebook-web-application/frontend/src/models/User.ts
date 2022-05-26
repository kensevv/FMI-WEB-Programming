import {Contact} from "./Contact"

export interface User {
    userId: number
    email: string
    username: string
    firstName: string
    lastName: string
    contacts?: Contact[]
}




