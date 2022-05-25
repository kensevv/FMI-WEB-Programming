import {User} from "../models/User"
import {PhoneType} from "../models/PhoneType";

let pNum1 = {phoneNumberId: 21, phoneNumber: "0877564534", type: PhoneType.Personal};
let pNum2 = {phoneNumberId: 22, phoneNumber: "0887675432", type: PhoneType.Personal};
let pNum3 = {phoneNumberId: 23, phoneNumber: "0889087654", type: PhoneType.Work};
let pNum4 = {phoneNumberId: 24, phoneNumber: "0876541209", type: PhoneType.Personal};
let pNum5 = {phoneNumberId: 25, phoneNumber: "0888888888", type: PhoneType.Work};
let pNum6 = {phoneNumberId: 26, phoneNumber: "6501234567", type: PhoneType.Home};

let addr1 = {addressId: 32, country: "Bulgaria", city: "Krumovgrad", zipCode: "6900"};
let addr2 = {addressId: 31, country: "Bulgaria", city: "Sofia", zipCode: "1700"};
let addr3 = {addressId: 33, country: "Bulgaria", city: "Sofia", street: "ul. Cherkovna"};
let addr4 = {addressId: 34, country: "Bulgaria"};
let addr5 = {addressId: 35, country: "USA"};

let contact1 = {contactId: 41, address: addr1, name: "Ivan", phoneNumbers: [pNum1]};
let contact2 = {contactId: 42, address: addr2, name: "Kenan", phoneNumbers: [pNum2, pNum3]};
let contact3 = {contactId: 43, address: addr3, name: "Ivo", phoneNumbers: [pNum3]};
let contact4 = {contactId: 44, address: addr4, name: "Evi", phoneNumbers: [pNum4, pNum5]};
let contact5 = {contactId: 45, address: addr5, name: "George", phoneNumbers: [pNum6]};

let usr1 = {userId: 11, userName: "ivantoskov", contacts: [contact2, contact3, contact4]};
let usr2 = {userId: 12, userName: "kensevv", contacts: [contact1, contact3, contact4]};
let usr3 = {userId: 13, userName: "ivsmars", contacts: [contact2, contact1, contact4]};
let usr4 = {userId: 14, userName: "Ewssi", contacts: [contact2, contact3, contact1, contact5]};
let usr5 = {userId: 15, userName: "gosho"};

export const mockedUsers: User[] = [usr1, usr2, usr3, usr4, usr5];
