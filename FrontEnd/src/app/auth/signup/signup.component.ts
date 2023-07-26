import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { errorMessage } from 'src/app/helpers/errors';
import { Router } from '@angular/router';
import { Role } from 'src/app/auth/interfaces/User';
import { MatSnackBar } from '@angular/material/snack-bar';

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
  constructor(private authService: AuthService, private router: Router, private _snackBar: MatSnackBar) {
    this.registerForm = new FormGroup({
      name: new FormControl('', [Validators.pattern('^[a-zA-Z]+$'), Validators.required]),
      username: new FormControl('', [Validators.pattern('^(?!^\\s+$)\\s*[A-Za-z\\s]+\\s*$'), Validators.required]),
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
      this.authService.register(this.registerForm.value).subscribe({
        next: ({data}: any) => {
          this.router.navigate(['/auth/signin'])
        }, 
        error: (error) => {
          this._snackBar.open(this.errorMessage.error, 'Aceptar', {
            duration: 5000,
            verticalPosition: 'top',
            panelClass: ['error-snackbar']
          });
        }
      })
      
    }
  }
}
