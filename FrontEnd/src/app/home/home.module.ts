import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page.component';
import { HomeListComponent } from './pages/home-list/home-list.component';
import { HomeRoutingModule } from './home-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { HeaderComponent } from './components/header/header.component';
import { RentComponent } from './pages/rent/rent.component';
import { CardHomeComponent } from './components/card-home/card-home.component';
import { ContactComponent } from './components/contact/contact.component';

@NgModule({
  declarations: [
    HomePageComponent,
    HomeListComponent,
    HeaderComponent,
    RentComponent,
    CardHomeComponent,
    ContactComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule
  ]
})

export class HomeModule { }
