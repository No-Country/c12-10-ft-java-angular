import { Homes, Ownership } from './../../interface/home.interface';
import { Component } from '@angular/core';

import { HomeService } from '../../services/home-service.service';
import { map, switchMap, tap } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Country } from '../../interface/home.interface';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-home-list',
  templateUrl: './home-list.component.html',
  styleUrls: ['./home-list.component.css']
})
export class HomeListComponent {

  public homes: Ownership[] = []

  public load: boolean = false;

  constructor(
    private _homeService:HomeService,
    private activeRoute: ActivatedRoute,
    private _spinner: NgxSpinnerService
    ) {

  }

  ngAfterViewInit(): void {

    this.activeRoute.params
    .subscribe(({country}) => {
      if(!(this._normalizeValue(country))) return;
      this.load = true;
      this._homeService.getHomesByCountry(this._normalizeValue(country)).subscribe(res =>{
        this.load = false;
        this.homes =res.data
      } )
    })

  }

  private _normalizeValue(value: string): string {
    return value.toLowerCase().replace(/\s/g, '');
  }

}




  // this.activeRoute.params
  // .pipe(
  //   switchMap(({country}) =>  this._homeService.getHomesByCountry(country))
  // )
  // .subscribe(homes => this.homes= homes.data)
//

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



