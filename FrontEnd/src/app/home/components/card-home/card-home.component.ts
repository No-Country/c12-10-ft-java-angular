import { Component, Input } from '@angular/core';

import { Route, Router } from '@angular/router';
import { Ownership } from '../../interface/home.interface';
import { blobFrom } from 'node-fetch';

@Component({
  selector: 'home-card-home',
  templateUrl: './card-home.component.html',

})
export class CardHomeComponent {

  @Input()
  public load: boolean = false;

  @Input()
  public home! : Ownership

  public list: number[] = [1,2,3,4,5,6,7,8,9,10,11,12]

  constructor(private router: Router) {}



  onClick = () => {
    // this.router.navigate('')
  }
}
