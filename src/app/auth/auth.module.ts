import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthRoutingModule } from './auth-rouuting.module';
import { AuthComponent } from './components/auth/auth.component';



@NgModule({
  declarations: [AuthComponent],
  imports: [
    CommonModule,
    AuthRoutingModule
  ],
  exports:[
    AuthComponent
  ]
})
export class AuthModule { }
