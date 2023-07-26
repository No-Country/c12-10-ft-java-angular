import { Component, OnInit, inject } from '@angular/core';
import { HomeService } from '../../services/home-service.service';
import { Observable, map, switchMap } from 'rxjs';

import { ActivatedRoute, Params } from '@angular/router';
import { Ownership } from '../../interfaces/home.interface';
import { Picture } from '../../interfaces/picture.interface';



@Component({
  selector: 'app-ownership',
  templateUrl: './ownership.component.html',
  styleUrls: ['./ownership.component.css']
})
export class OwnershipComponent implements OnInit {

  public homes:Ownership[] =[];
  data = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]

  public loading!:boolean;
  pictures!:string[];
  principalPicture!: string

  public value:Params | undefined;

  private _homeService = inject(HomeService);

  constructor(
    private activeRoute: ActivatedRoute,
  ){}

  ngOnInit(): void {
    this.getHomes()


  }

  getHomes() {
    this.activeRoute.params
    .subscribe(({country}) => {
      console.log('here =>',country);
      (country === undefined) ? this.defaultData() : this.getDataByCountry(country)
    }
      );

  }

   defaultData() {
  //   this._homeService.getAllHome()
  //   .pipe(
  //     map((resp) => resp.data.map(home => {
  //       console.log('here =>',home.id)
  //       this._homeService.getPictureOwnership(home.id)
  //       // .subscribe((resp) =>{
  //       //   home.images = resp.data.images[0];
  //       //   console.log('here =>',home.images)
  //       // }  )
  //     }))
  //   )
  //   .subscribe(home => {

  //     console.log(resp, 'res')
  //   })
  //   // .subscribe(home =>{
  //   // this.homes = home.data;

  //   // } );
   }

  getDataByCountry(country:string) {
    this._homeService.getHomesByCountry(country).subscribe(res =>{
      this.homes =res.data
    } );
  }

  getPictures(id:string): void {
    console.log(id, 'id en picture')
    this._homeService.getPictureOwnership(id)
      .subscribe((res) => {
        this.pictures = res.data.images;
        this.principalPicture = this.pictures[0];
      });
  }

  // private _normalizeValue(value: string): string {
  //   return value.toLowerCase().replace(/\s/g, '');
  // }
}


