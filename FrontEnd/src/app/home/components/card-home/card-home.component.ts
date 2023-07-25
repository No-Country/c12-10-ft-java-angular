import { Component, Input } from '@angular/core';

import { Route, Router } from '@angular/router';
import { Ownership } from '../../interfaces/home.interface';



@Component({
  selector: 'home-card-home',
  templateUrl: './card-home.component.html',

})
export class CardHomeComponent {


  @Input()
  public home! : Ownership;

  @Input()
  public picture! : string;
  constructor(private router: Router) {}

  onClick = (id:string) => {
    this.router.navigate([`detail-home/${id}`]);
  }


}
