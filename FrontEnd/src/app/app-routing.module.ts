import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { RentComponent } from './components/rent/rent.component';

const routes: Routes = [
  { path: 'signin', component: LoginComponent }, 
  { path: 'signup', component: SignupComponent },
  { path: 'rent', component: RentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
