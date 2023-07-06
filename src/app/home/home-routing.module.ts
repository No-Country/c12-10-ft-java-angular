import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { DetailHomeComponent } from './pages/detail-home/detail-home.component';
import { HomesComponent } from './pages/homes/homes.component';

const routes: Routes = [

    {
      path: '',
      component: HomePageComponent,
      children: [
        { path: 'detail-home', component: DetailHomeComponent },
        { path: 'list', component: HomesComponent },
        { path: '**', redirectTo: 'list' },
      ]
    }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
