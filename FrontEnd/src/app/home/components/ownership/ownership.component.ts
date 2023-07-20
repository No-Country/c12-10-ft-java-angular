import { Component, OnInit, inject } from '@angular/core';
import { HomeService } from '../../services/home-service.service';
import { Observable } from 'rxjs';

import { ActivatedRoute, Params } from '@angular/router';
import { Ownership } from '../../interfaces/home.interface';



@Component({
  selector: 'app-ownership',
  templateUrl: './ownership.component.html',
  styleUrls: ['./ownership.component.css']
})
export class OwnershipComponent implements OnInit {

  public homes:Ownership[] =[];
  data = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]

  public loading!:boolean;

  public value:Params | undefined;

  private _homeService = inject(HomeService);

  constructor(
    private activeRoute: ActivatedRoute,
  ){}

  ngOnInit(): void {

    this.getHomes()


  }


  ngAfterViewInit(): void {

    this.activeRoute.params
    .subscribe(({country}) => {
      if((!this._normalizeValue(country))){
        console.log("Please select");
      };
      this._homeService.getHomesByCountry(this._normalizeValue(country)).subscribe(res =>{
        this.homes =res.data
      } )
    })

  }
  getHomes() {
    this.activeRoute.params
    .subscribe(({rs}) => {
      if(rs === undefined){
        this.defaultData()
      }
      this.getDataByCountry(rs)
    }
      );

  }

  defaultData() {
    this._homeService.getAllHome().subscribe(home =>{
    this.homes = home.data;
    } );
  }

  getDataByCountry(country:any){
    this._homeService.getHomesByCountry(this._normalizeValue(country)).subscribe(res =>{
      this.homes =res.data
    } );
  }

  private _normalizeValue(value: any): any {
    return value.toLowerCase().replace(/\s/g, '');
  }
}


