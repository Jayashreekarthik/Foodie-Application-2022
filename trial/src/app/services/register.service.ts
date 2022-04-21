import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Register } from '../models/register';
import { Location } from 'src/Location';
@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  signupForm(register:Register){
    return this.http.post<Register>('http://localhost:9004/api/v3/register',register);
  }
}