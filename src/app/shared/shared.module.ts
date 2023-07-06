import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardHomeComponent } from '../home/components/card-home/card-home.component';
import { SearchComponent } from './components/search/search.component';



@NgModule({
  declarations: [
    SearchComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SearchComponent
    ]
})
export class SharedModule { }
