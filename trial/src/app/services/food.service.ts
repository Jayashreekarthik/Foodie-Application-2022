import { Injectable } from '@angular/core';
import { Foods } from '../food';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor() { }
  getFoodById(id:number):Foods{
     return this.getAll().find(food => food.id == id)!;
  }

  getAll():Foods[]{
    return[
     {
       id:1,
       name:'Pizza',
       price:120,
       cookTime:'10-20',
       favorite:false,
       origins:['persia','middle east','india'],
       imageUrl:'/assets/chicken-pizza.jpeg',
        tags:['fastFood', 'non-veg'],
     },
     {
      id:2,
      name:'Biryani',
      price:250,
      cookTime:'20-30',
      favorite:true,
      origins:['Hyderabad','middle east'],
      imageUrl:'/assets/biryani.webp',
      tags:['slowFood', 'Lunch'],
      },
      {
        id:3,
        name:'Burger',
        price:180,
        cookTime:'10-15',
        favorite:false,
        origins:['french','middle east','china'],
        imageUrl:'/assets/burger.jpg',
        tags:['slowFood', 'veg'],
      },
      {
        id:4,
        name:'Panner-Butter-Masala',
        price:210,
        cookTime:'5-10',
        favorite:true,
        origins:['India','middle east'], 
        imageUrl:'/assets/paneer-butter-masala.jpg',
        tags:['curry', 'slowfood'],
      },
      {
        id:5,
        name:'Pasta',
        price:150,
        cookTime:'5-10',
        favorite:false,
        origins:['persia','India','china'],  
        imageUrl:'/assets/pasta.jpg',
        tags:['starter', 'fastfood'],
      },
      {
        id:6,
        name:'Veg Manchurian',
        price:120,
        cookTime:'10-15',
        favorite:true,
        origins:['India','middle east','china'],       
        imageUrl:'https://wallpapercave.com/wp/wp4914622.jpg',
        tags:['snack', 'starter'],
      },
      {
        id:7,
        name:'Vegitable Pulav',
        price:240,
        cookTime:'10-20',
        favorite:false,
        origins:['south'],
        imageUrl:'/assets/PULAV.jpg',
        tags:['rice', 'Lunch'],
      },
      {
        id:8,
        name:'Noodles',
        price:160,
        cookTime:'5-10',
        favorite:true,
        origins:['persia','middle east','china'], 
        imageUrl:'/assets/noodles.jpg',
        tags:['fastfood', 'snack'],
      },
      {
        id:9,
        name:'Vegitable Soup',
        price:190,
        cookTime:'10-15',
        favorite:true,
        origins:['persia','china'],
        imageUrl:'/assets/veg-soup.jpg',
        tags:['starter', 'soup'],
      }
    ]
  }
}
