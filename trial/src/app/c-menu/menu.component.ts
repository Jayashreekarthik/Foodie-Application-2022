import { Component, OnInit } from '@angular/core';
import { Foods } from '../food';
import { FoodService } from '../services/food.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  foods:Foods[]=[];
  constructor(private fs:FoodService , private route:ActivatedRoute) { }

  ngOnInit(): void {
      this.route.params.subscribe(params =>{
        if(params['searchItem'])
        this.foods = this.fs.getAll().filter(food => food.name.toLowerCase().includes(params['searchItem'].toLowerCase()));
        else
         this.foods=this.fs.getAll();
      })


   
  }

}
