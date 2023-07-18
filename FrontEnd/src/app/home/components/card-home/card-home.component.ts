import { Component, Input } from '@angular/core';

import { Route, Router } from '@angular/router';
import { newHome } from '../../interfaces/home.interface';

@Component({
  selector: 'home-card-home',
  templateUrl: './card-home.component.html',

})
export class CardHomeComponent {


  @Input()
  public home! : newHome

  constructor(private router: Router) {}



  onClick = () => {
    // this.router.navigate('')
  }
}
