import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { errorMessage } from 'src/app/helpers/errors';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup
  errorMessage = errorMessage
  submitted = false;
  constructor() {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.pattern('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'), Validators.required]),
      password: new FormControl('', Validators.required),
    })
  }
  get f() { return this.loginForm.controls }
  login() {
    this.submitted = true
    console.log(this.loginForm.value)
  }
}
