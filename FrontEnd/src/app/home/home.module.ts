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
import { PropertyRegisterComponent } from './pages/property-register/property-register.component';
import { PropertyRegisterAccommodationComponent } from './components/property-register-accommodation/property-register-accommodation.component';
import { PropertyRegisterImagesComponent } from './components/property-register-images/property-register-images.component';
import { PropertyRegisterServicesComponent } from './components/property-register-services/property-register-services.component';

@NgModule({
  declarations: [
    HomePageComponent,
    HomeListComponent,
    HeaderComponent,
    RentComponent,
    CardHomeComponent,
    ContactComponent,
    PropertyRegisterComponent,
    PropertyRegisterAccommodationComponent,
    PropertyRegisterImagesComponent,
    PropertyRegisterServicesComponent
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
