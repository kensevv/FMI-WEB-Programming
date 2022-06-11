import { PhoneType } from "./PhoneType"

export interface PhoneNumber {
    phoneNumberUuid : string
    phoneNumber : string
    type : PhoneType
}