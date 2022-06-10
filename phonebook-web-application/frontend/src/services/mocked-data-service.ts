import {User} from "../models/User"
import {PhoneType} from "../models/PhoneType";
import {PhoneNumber} from "../models/PhoneNumber";
import {Address} from "../models/Address";
import {Contact} from "../models/Contact";

const pNum1: PhoneNumber = {phoneNumberUuid: 21, phoneNumber: "0877564534", type: PhoneType.Personal};
const pNum2: PhoneNumber = {phoneNumberUuid: 22, phoneNumber: "0887675432", type: PhoneType.Personal};
const pNum3: PhoneNumber = {phoneNumberUuid: 23, phoneNumber: "0889087654", type: PhoneType.Work};
const pNum4: PhoneNumber = {phoneNumberUuid: 24, phoneNumber: "0876541209", type: PhoneType.Personal};
const pNum5: PhoneNumber = {phoneNumberUuid: 25, phoneNumber: "0888888888", type: PhoneType.Work};
const pNum6: PhoneNumber = {phoneNumberUuid: 26, phoneNumber: "6501234567", type: PhoneType.Home};

const addr1: Address = {addressUuid: 32, country: "Bulgaria", city: "Krumovgrad", zipCode: "6900", street: "Ivan Vazov 5"};
const addr2: Address = {addressUuid: 31, country: "Bulgaria", city: "Sofia", zipCode: "1700", street: "Vitosha 145"};
const addr3: Address = {addressUuid: 33, country: "Bulgaria", city: "Sofia", zipCode: "1700", street: "ul. Cherkovna 12"};
const addr4: Address = {addressUuid: 34, country: "Bulgaria", city: "Borino", zipCode: "4354", street: "Maritsa 9"};
const addr5: Address = {addressUuid: 35, country: "USA", city: "New York", zipCode: "1111", street: "Stockman PI 2"};

const contact1: Contact = {contactUuid: 41, address: addr1, email: "ivantoskov@gmail.com", name: "Ivan", photo: undefined, phoneNumbers: [pNum1]};
const contact2: Contact = {contactUuid: 42, address: addr2, email: "kensevv@gmail.com", name: "Kenan", photo: undefined, phoneNumbers: [pNum2, pNum3]};
const contact3: Contact = {contactUuid: 43, address: addr3, email: "ivsmars@gmail.com", name: "Ivo", photo: undefined, phoneNumbers: [pNum3]};
const contact4: Contact = {contactUuid: 44, address: addr4, email: "Ewssi@gmail.com", name: "Evi", photo: undefined, phoneNumbers: [pNum4, pNum5]};
const contact5: Contact = {contactUuid: 45, address: addr5, email: "george@gmail.com", name: "George", photo: undefined, phoneNumbers: [pNum6]};

const usr1: User = {userUuid: 11, email: "ivantoskov@gmail.com", username: "ivantoskov", firstName: 'Ivan', lastName: 'Toskov', contacts: [contact2, contact3, contact4]};
const usr2: User = {userUuid: 12, email: "kensevv@gmail.com", username: "kensevv", firstName: 'Kenan', lastName: 'Yusein', contacts: [contact1, contact3, contact4]};
const usr3: User = {userUuid: 13, email: "ivsmars@gmail.com", username: "ivsmars", firstName: 'Ivo', lastName: 'Marinov', contacts: [contact2, contact1, contact4]};
const usr4: User = {userUuid: 14, email: "Ewssi@gmail.com", username: "Ewssi", firstName: 'Evelina', lastName: 'Popova', contacts: [contact2, contact3, contact1, contact5]};
const usr5: User = {userUuid: 15, email: "gosho@gmail.com", username: "gosho", firstName: 'Georgi', lastName: 'Petrov', contacts: undefined};

export const mockedUsers: User[] = [usr1, usr2, usr3, usr4, usr5];
