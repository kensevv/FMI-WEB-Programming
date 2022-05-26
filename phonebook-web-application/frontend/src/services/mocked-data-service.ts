import {User} from "../models/User"
import {PhoneType} from "../models/PhoneType";
import {PhoneNumber} from "../models/PhoneNumber";
import {Address} from "../models/Address";
import {Contact} from "../models/Contact";

const pNum1: PhoneNumber = {phoneNumberId: 21, phoneNumber: "0877564534", type: PhoneType.Personal};
const pNum2: PhoneNumber = {phoneNumberId: 22, phoneNumber: "0887675432", type: PhoneType.Personal};
const pNum3: PhoneNumber = {phoneNumberId: 23, phoneNumber: "0889087654", type: PhoneType.Work};
const pNum4: PhoneNumber = {phoneNumberId: 24, phoneNumber: "0876541209", type: PhoneType.Personal};
const pNum5: PhoneNumber = {phoneNumberId: 25, phoneNumber: "0888888888", type: PhoneType.Work};
const pNum6: PhoneNumber = {phoneNumberId: 26, phoneNumber: "6501234567", type: PhoneType.Home};

const addr1: Address = {addressId: 32, country: "Bulgaria", city: "Krumovgrad", zipCode: "6900", street: "Ivan Vazov 5"};
const addr2: Address = {addressId: 31, country: "Bulgaria", city: "Sofia", zipCode: "1700", street: "Vitosha 145"};
const addr3: Address = {addressId: 33, country: "Bulgaria", city: "Sofia", zipCode: "1700", street: "ul. Cherkovna 12"};
const addr4: Address = {addressId: 34, country: "Bulgaria", city: "Borino", zipCode: "4354", street: "Maritsa 9"};
const addr5: Address = {addressId: 35, country: "USA", city: "New York", zipCode: "1111", street: "Stockman PI 2"};

const contact1: Contact = {contactId: 41, address: addr1, email: "ivantoskov@gmail.com", name: "Ivan", photo: undefined, phoneNumbers: [pNum1]};
const contact2: Contact = {contactId: 42, address: addr2, email: "kensevv@gmail.com", name: "Kenan", photo: undefined, phoneNumbers: [pNum2, pNum3]};
const contact3: Contact = {contactId: 43, address: addr3, email: "ivsmars@gmail.com", name: "Ivo", photo: undefined, phoneNumbers: [pNum3]};
const contact4: Contact = {contactId: 44, address: addr4, email: "Ewssi@gmail.com", name: "Evi", photo: undefined, phoneNumbers: [pNum4, pNum5]};
const contact5: Contact = {contactId: 45, address: addr5, email: "george@gmail.com", name: "George", photo: undefined, phoneNumbers: [pNum6]};

const usr1: User = {userId: 11, email: "ivantoskov@gmail.com", username: "ivantoskov", firstName: 'Ivan', lastName: 'Toskov', contacts: [contact2, contact3, contact4]};
const usr2: User = {userId: 12, email: "kensevv@gmail.com", username: "kensevv", firstName: 'Kenan', lastName: 'Yusein', contacts: [contact1, contact3, contact4]};
const usr3: User = {userId: 13, email: "ivsmars@gmail.com", username: "ivsmars", firstName: 'Ivo', lastName: 'Marinov', contacts: [contact2, contact1, contact4]};
const usr4: User = {userId: 14, email: "Ewssi@gmail.com", username: "Ewssi", firstName: 'Evelina', lastName: 'Popova', contacts: [contact2, contact3, contact1, contact5]};
const usr5: User = {userId: 15, email: "gosho@gmail.com", username: "gosho", firstName: 'Georgi', lastName: 'Petrov', contacts: undefined};

export const mockedUsers: User[] = [usr1, usr2, usr3, usr4, usr5];
