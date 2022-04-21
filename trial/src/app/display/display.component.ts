import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Register } from '../models/register';
import { RegisterService } from '../services/register.service';
import { ToastService } from '../toast.service';
import { User } from '../User';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
    signupForm: FormGroup = new FormGroup({});  

  constructor(private formBuilder: FormBuilder , private http:HttpClient, private router: Router,public registerService: RegisterService) {}
  
  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
        name: ['', Validators.required , Validators.minLength(5)],
        mobile: ['', Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")],
        email: ['', [Validators.required, Validators.email,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
        password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
  get f(){  
    return this.signupForm.controls;  
  }  
  signUp(data: any){
    this.registerService.signupForm(data) 
    .subscribe(res=>{
      console.log("result"+res);
      alert("Signup is successfull");
      this.signupForm.reset();
      this.router.navigate(['login']);
    },err=>{
      alert("Something went wrong");
    })
  }
}

