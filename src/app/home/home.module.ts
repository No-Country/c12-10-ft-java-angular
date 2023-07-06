import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardHomeComponent } from './components/card-home/card-home.component';
import { HomeRoutingModule } from './home-routing.module';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { SharedModule } from '../shared/shared.module';
import { HeaderComponent } from './components/header/header.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { DetailHomeComponent } from './pages/detail-home/detail-home.component';
import { HomesComponent } from './pages/homes/homes.component';




@NgModule({
  declarations: [
    CardHomeComponent,
    HomePageComponent,
    HeaderComponent,
    CarouselComponent,
    DetailHomeComponent,
    HomesComponent,




  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule,




  ],
  exports: [
    CardHomeComponent,


  ]
})
export class HomeModule { }
