import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AboutComponent } from './c-about/about.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VendorComponent } from './vendor/vendor.component';
import { MenuComponent } from './c-menu/menu.component';
import { DisplayComponent } from './display/display.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './c-navbar/navbar.component';
import { FooterComponent } from './c-footer/footer.component';
import { RestaurantComponent } from './vendorpages/restaurant/restaurant.component';
import { MenulistComponent } from './vendorpages/menulist/menulist.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './c-home/home.component';
import { CartComponent } from './c-cart/cart.component';
import { NgToastModule } from 'ng-angular-popup';
import { ReactiveFormsModule } from '@angular/forms';
import {MatTabsModule} from '@angular/material/tabs';
import { FoodpageComponent } from './foodpage/foodpage.component';
import { SearchComponent } from './search/search.component';
import { FormsModule } from '@angular/forms';
import { ContactComponent } from './c-contact/contact.component';
import { VNavbarComponent } from './v-navbar/v-navbar.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { ProfileComponent } from './profile/profile.component';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import { MatBadgeModule } from '@angular/material/badge';
import {MatToolbarModule} from '@angular/material/toolbar';
import{ MatAutocompleteModule } from '@angular/material/autocomplete';
import {MatDialogModule} from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    VendorComponent,
    DisplayComponent,
    LoginComponent,
    NavbarComponent,
    FooterComponent,
    RestaurantComponent,
    MenulistComponent,
    HomeComponent,
    CartComponent,
    FoodpageComponent,
    SearchComponent,
    MenuComponent,
    ContactComponent,
    AboutComponent,
    VNavbarComponent,
    FavouriteComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgToastModule,
    ReactiveFormsModule,
    MatTabsModule,
    FormsModule,
    MatAutocompleteModule,
    MatToolbarModule,
    MatIconModule,
    MatSelectModule,
    MatBadgeModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
