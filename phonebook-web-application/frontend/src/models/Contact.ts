import { Address } from "./Address"
import { PhoneNumber } from "./PhoneNumber"

export interface Contact {
    contactUuid? : string
    address : Address
    email? : string
    name : string
    photo? : Blob
    phoneNumbers : PhoneNumber[]
}