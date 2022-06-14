import axios from 'axios'
import {LoginRequest, SignupRequest} from "../models/Authentication";
import {User} from "../models/User";
import {Contact} from "../models/Contact";

export const api = axios.create({baseURL: '/api'})

export const userLogin = async (loginRequest: LoginRequest) =>
    api.post('/login', loginRequest, {
        baseURL: "/auth",
    })

export const registerUser = async (registerRequest: SignupRequest) =>
    api.post<User>('/register', registerRequest, {
        baseURL: "/auth",
    })

export const logoutUser = () =>
    api.get<User>('/logout', {
        baseURL: "/auth",
    }).then(r => r.data)

export const addNewContactToCurrentUser = async (newContact: Contact) => {
    return api.post("/contact", newContact).then(r => r.data);
}

export const getCurrentUserContacts = async (): Promise<Contact[]> =>
    api.get<Contact[]>("/contact").then(r => r.data)

export const deleteContactById = async (contactUuid) =>
    api.delete(`/contact/${contactUuid}`).then(r => r.data)

export const updateContact = async (contact) =>
    api.put("/contact", contact).then(r => r.data)