import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './c-menu/menu.component';
import { DisplayComponent } from './display/display.component';
import { LoginComponent } from './login/login.component';
import { RestaurantComponent } from './vendorpages/restaurant/restaurant.component';
import { VendorComponent } from './vendor/vendor.component';
import { HomeComponent } from './c-home/home.component';
import { AboutComponent } from './c-about/about.component';
import { ContactComponent } from './c-contact/contact.component';
import { CartComponent } from './c-cart/cart.component';
import { FoodpageComponent } from './foodpage/foodpage.component';
import { NavbarComponent } from './c-navbar/navbar.component';
import { MenulistComponent } from './vendorpages/menulist/menulist.component';
import { ProfileComponent } from './profile/profile.component';


const routes: Routes = [
  {
    path:"",component:DisplayComponent
  },
  {
    path:"vendor",component:VendorComponent
  },
  {
    path:"c-menu",component:MenuComponent
  },
  {
    path:"login",component:LoginComponent
  },
  {
    path:"restaurant",component:RestaurantComponent
  },
  {
    path:"c-home",component:HomeComponent
  },
  {
    path:"c-about",component:AboutComponent
  },
  {
    path:"c-contact",component:ContactComponent
  },
  {
    path:"c-cart",component:CartComponent
  },
  {
    path:"food/:id",component:FoodpageComponent
  },
  {
    path:"search/:searchItem" , component:MenuComponent
  },
  {
    path:"c-navbar",component:NavbarComponent
  },
  {
    path:"menulist",component:MenulistComponent
  },
  {
    path:"restaurant",component:RestaurantComponent
  },
  {
    path:"profile",component:ProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
