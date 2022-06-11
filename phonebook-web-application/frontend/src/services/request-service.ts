import axios from 'axios'
import {LoginRequest, SignupRequest} from "../models/Authentication";
import {User} from "../models/User";

export const api = axios.create({baseURL: '/api'})

export const userLogin = (loginRequest: LoginRequest) =>
    api.post('/login', loginRequest, {
        baseURL: "/auth",
    })

export const registerUser = (registerRequest: SignupRequest) =>
    api.post<User>('/register', registerRequest, {
        baseURL: "/auth",
    })

export const logoutUser = () =>
    api.get<User>('/logout', {
        baseURL: "/auth",
    }).then(r => r.data)
