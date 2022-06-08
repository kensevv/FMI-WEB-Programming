import { Address } from "./Address"
import { PhoneNumber } from "./PhoneNumber"

export interface Contact {
    contactUuId? : string
    address : Address
    email? : string
    name : string
    photo? : Blob
    phoneNumbers : PhoneNumber[]
}