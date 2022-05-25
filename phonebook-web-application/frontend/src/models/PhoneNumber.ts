import { PhoneType } from "./PhoneType"

export interface PhoneNumber {
    phoneNumberId : number
    phoneNumber : string
    type : PhoneType
}