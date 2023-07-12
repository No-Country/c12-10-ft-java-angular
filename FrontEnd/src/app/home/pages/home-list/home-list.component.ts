import { Component } from '@angular/core';
import { newHome } from '../../interface/home.interface';
import { HomeService } from '../../services/home-service.service';
import { map, switchMap } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home-list',
  templateUrl: './home-list.component.html',
  styleUrls: ['./home-list.component.css']
})
export class HomeListComponent {

  public homes: newHome[] = []

  constructor(
    private _homeService:HomeService,
    private activeRoute: ActivatedRoute
    ) {

  }


  ngAfterViewInit(): void {
    this.activeRoute.queryParams
    .pipe(
      switchMap(country => this._homeService.getHomes(country)),
    )
    .subscribe(homes => this.homes= homes)
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
