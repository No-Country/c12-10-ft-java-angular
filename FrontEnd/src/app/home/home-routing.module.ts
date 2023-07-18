import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeListComponent } from './pages/home-list/home-list.component';
import { RentComponent } from './pages/rent/rent.component';
import { PropertyRegisterComponent } from '../property-register/property-register.component';
import { HomePageComponent } from './home-page.component';


const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
    children: [
      { path: 'detail-home', component: RentComponent },
      { path: 'list', component: HomeListComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
