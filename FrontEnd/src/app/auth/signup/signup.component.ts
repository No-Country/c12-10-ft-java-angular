import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { errorMessage } from 'src/app/helpers/errors';
import { Router } from '@angular/router';
import { Role } from 'src/app/property-register/interfaces/User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent {
  public role: boolean = false 
  type = {
    owner: Role.OWNER,
    tenant: Role.TENANT
  }
  errorMessage = errorMessage
  submitted = false;
  public registerForm: FormGroup
  constructor(private authService: AuthService, private router: Router) {
    this.registerForm = new FormGroup({
      name: new FormControl('', [Validators.pattern('^[a-zA-Z]+$'), Validators.required]),
      user: new FormControl('', [Validators.pattern('^(?!^\\s+$)\\s*[A-Za-z\\s]+\\s*$'), Validators.required]),
      email: new FormControl('', [Validators.pattern('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'), Validators.required]),
      password: new FormControl('', [Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/), Validators.required]),
      role: new FormControl('', Validators.required),
    })
  }
  get f() { return this.registerForm.controls; }
  activateRol() {
    this.role = !this.role
  }
  changeOwner() {
    this.setRole(this.type.owner)
  }
  changeTenant() {
    this.setRole(this.type.tenant)
  }
  setRole(value: string) {
    const role = this.registerForm.get('role');
    if(role) {
      role.setValue(value.toUpperCase())
      this.role = false
    }
  }
  register() {
    this.submitted = true
    if(this.registerForm.valid) {
      this.authService.register(this.registerForm.value).subscribe(({data}: any) => {
        window.localStorage.setItem('userId', data.id)
        this.router.navigate(['/auth/signin'])
      })
    }
  }
}
