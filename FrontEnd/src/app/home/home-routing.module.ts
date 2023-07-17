import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeListComponent } from './pages/home-list/home-list.component';
import { RentComponent } from './pages/rent/rent.component';
import { HomePageComponent } from './home-page.component';
import { CardUserComponent } from './components/card-user/card-user.component';
import { OwnershipComponent } from './pages/ownership/ownership.component';

const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
    children: [
      { path: 'detail-home', component: RentComponent },
      { path: 'list/:country', component: HomeListComponent },
      { path: 'card', component: CardUserComponent },
      { path: '**', component: OwnershipComponent },

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
