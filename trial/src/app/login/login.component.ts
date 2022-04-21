import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, PatternValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
 loginForm!: FormGroup
  constructor(private formBuilder: FormBuilder,private http:HttpClient,public loginService:LoginService,private router : Router) { }
  emailPattern = "^[a-z0-9._%+-]+@gmail+\.[a-z]{2,4}$";
  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  }
  get f(){  
    return this.loginForm.controls;  
  } 
  login(data:any){
    this.loginService.loginForm(data) 
    .subscribe(res=>{
      console.log("result"+res);
      alert("Login is successfull");
      this.loginForm.reset();
      this.router.navigate(['c-home']);
    },err=>{
      alert("Something went wrong");
    })
       
  }
}