import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-v-navbar',
  templateUrl: './v-navbar.component.html',
  styleUrls: ['./v-navbar.component.css']
})
export class VNavbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  vlogout(){
    alert("You will be Logged Out")
  }
}
