import { Component, Input } from '@angular/core';
import { Home } from '../../../shared/interfaces/home.interface';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'home-card-home',
  templateUrl: './card-home.component.html',

})
export class CardHomeComponent {


  @Input()
  public home! : Home

  constructor(private router: Router) {}



  onClick = () => {
    // this.router.navigate('')
  }
}
