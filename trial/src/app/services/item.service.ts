import { Injectable } from '@angular/core';
import { Items } from '../item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }
    getItemById(id:number):Items{
      return this.getAll().find(item => item.id == id)!;
   
    }
    
    getAll():Items[]{
      return[
       {
         id:1,
         name:'Pizza',
         price:120,
         cookTime:'10-20',
         imageUrl:'/assets/chicken-pizza.jpeg'
       },
       {
        id:2,
        name:'Biryani',
        price:250,
        cookTime:'20-30',
        imageUrl:'/assets/biryani.webp'
        },
        {
          id:3,
          name:'Burger',
          price:180,
          cookTime:'10-15',
          imageUrl:'/assets/burger.jpg'
        },
        {
          id:4,
          name:'Panner-Butter-Masala',
          price:210,
          cookTime:'5-10',
          imageUrl:'/assets/paneer-butter-masala.jpg'
        },
        {
          id:5,
          name:'Pasta',
          price:150,
          cookTime:'5-10',
          imageUrl:'/assets/pasta.jpg',
        },
        {
          id:6,
          name:'Veg Manchurian',
          price:120,
          cookTime:'10-15',
          imageUrl:'https://wallpapercave.com/wp/wp4914622.jpg'
        },
        {
          id:7,
          name:'Vegitable Pulav',
          price:240,
          cookTime:'10-20',
          imageUrl:'/assets/PULAV.jpg'
        },
        {
          id:8,
          name:'Noodles',
          price:160,
          cookTime:'5-10',
          imageUrl:'/assets/noodles.jpg'
        },
        {
          id:9,
          name:'Vegitable Soup',
          price:190,
          cookTime:'10-15',
          imageUrl:'/assets/veg-soup.jpg'
        }
      ]
    }
}
