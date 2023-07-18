import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PropertyRegisterComponent } from './property-register/property-register.component';
import { PropertyRegisterAccommodationComponent } from './property-register/components/property-register-accommodation/property-register-accommodation.component';
import { PropertyRegisterImagesComponent } from './property-register/components/property-register-images/property-register-images.component';
import { PropertyRegisterServicesComponent } from './property-register/components/property-register-services/property-register-services.component';

@NgModule({
  declarations: [
    AppComponent,
    PropertyRegisterComponent,
    PropertyRegisterAccommodationComponent,
    PropertyRegisterImagesComponent,
    PropertyRegisterServicesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
