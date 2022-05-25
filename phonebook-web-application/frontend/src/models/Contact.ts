import { Address } from "./Address"
import { PhoneNumber } from "./PhoneNumber"

export interface Contact {
    contactId : number 
    address : Address
    email? : string
    name : string
    photo? : Blob
    phoneNumbers : PhoneNumber[]
}
