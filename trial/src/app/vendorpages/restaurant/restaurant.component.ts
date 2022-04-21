import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Restaurant } from 'src/app/Restaurant';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  formvalue !:FormGroup;
  restaurantmodel : Restaurant = new Restaurant
  constructor(private formbuilder:FormBuilder , private api:ApiService) { }

  get f(){  
    return this.formvalue.controls;  
  }  

  ngOnInit(): void {
    this.formvalue = this.formbuilder.group({
      restaurantName : ['',Validators.required , Validators.minLength(5)],
      restaurantCity : ['',Validators.required , Validators.minLength(5)],
      restaurantAddress : ['',Validators.required , Validators.minLength(5)],
      vendorName : ['',Validators.required , Validators.minLength(5)],
      vendorEmail : ['',[Validators.required, Validators.email,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      vendorMobile : ['',Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]
    })

  }
  postRestaurant(){
    this.restaurantmodel.restaurantName= this.formvalue.value.restaurantName;
    this.restaurantmodel.restaurantCity= this.formvalue.value.restaurantCitye;
    this.restaurantmodel.restaurantAddress= this.formvalue.value.restaurantAddress;
    this.restaurantmodel.vendorName= this.formvalue.value.vendorName;
    this.restaurantmodel. vendorEmail= this.formvalue.value. vendorEmail;
    this.restaurantmodel.vendorMobile= this.formvalue.value.vendorMobile;

    this.api.postRestaurant(this.restaurantmodel)
    .subscribe(res=>{
      console.log(res);
      alert("Restaurant added successfully")
    },
    err=>{
      alert("something went wrong");
    })
  }

}
