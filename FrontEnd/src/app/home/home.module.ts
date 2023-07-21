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
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { OwnershipComponent } from './components/ownership/ownership.component';

import {MatExpansionModule} from '@angular/material/expansion';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatStepperModule} from '@angular/material/stepper';
import { UrlImagePipe } from './pipes/url-image.pipe';
import { PluralPipe } from './pipes/plural.pipe';
import { CardUserComponent } from './components/card-user/card-user.component';
import { RegisterReviewComponent } from './components/register-review/register-review.component';
import { DetailReviewComponent } from './components/detail-review/detail-review.component';
import { CarouselComponent } from './components/carousel/carousel.component';


@NgModule({
  declarations: [
    HomePageComponent,
    HomeListComponent,
    HeaderComponent,
    RentComponent,
    CardHomeComponent,
    ContactComponent,
    OwnershipComponent,
    UrlImagePipe,
    PluralPipe,
    CardUserComponent,
    RegisterReviewComponent,
    DetailReviewComponent,
    CarouselComponent,

  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatStepperModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatExpansionModule,


  ]
})

export class HomeModule { }
