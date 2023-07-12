import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  public rol: boolean = false 

  constructor() {
    
  }
  activateRol() {
    this.rol = !this.rol
  }
}
