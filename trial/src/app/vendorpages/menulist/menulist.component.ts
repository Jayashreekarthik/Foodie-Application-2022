import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Items } from 'src/app/item';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-menulist',
  templateUrl: './menulist.component.html',
  styleUrls: ['./menulist.component.css']
})
export class MenulistComponent implements OnInit {
  items:Items[]=[];
  constructor(private itemservice:ItemService , private route:ActivatedRoute) { 
    
  }

  ngOnInit(): void {
    this.route.params.subscribe(params =>{
      if(params['searchItem'])
      this.items = this.itemservice.getAll().filter(food => food.name.toLowerCase().includes(params['searchItem'].toLowerCase()));
      else
       this.items=this.itemservice.getAll();
    })
  }

}
