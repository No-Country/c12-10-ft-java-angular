import { Component } from '@angular/core';

import { HomeService } from '../../services/home-service.service';
import { map, switchMap } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Ownership } from 'src/app/property-register/interfaces/Ownership';

@Component({
  selector: 'app-home-list',
  templateUrl: './home-list.component.html',
  styleUrls: ['./home-list.component.css']
})
export class HomeListComponent {

  public homes: Ownership[] = [];
  value!: any;

  constructor(
    private _homeService:HomeService,
    private activeRoute: ActivatedRoute
    ) {

  }


  ngAfterViewInit(): void {

  }


  // constructor(
  //   private _homeService:HomeService,
  //   ) {

  // }

  // getHomes(country:string) {
  //   this._homeService.getHomes()
  //   .pipe(
  //     map(homes => homes.filter(home => this._normalizeValue(home.country).includes(this._normalizeValue(country))) )
  //   )
  //   .subscribe(homes => {
  //     this.homes = homes
  //     console.log(this.homes)
  //   })
  // }

  // private _normalizeValue(value: string): string {
  //   return value.toLowerCase().replace(/\s/g, '');
  // }

}
