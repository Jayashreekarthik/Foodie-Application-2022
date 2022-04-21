import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  loginForm(login:Login){
    return this.http.post<Login>('http://localhost:9004/api/v3/login',login);
  }
}
