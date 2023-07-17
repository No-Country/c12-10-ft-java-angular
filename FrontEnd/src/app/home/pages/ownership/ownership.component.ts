import { Component, OnInit } from '@angular/core';
import { HomeService } from '../../services/home-service.service';
import { Ownership } from '../../interface/home.interface';

@Component({
  selector: 'app-ownership',
  templateUrl: './ownership.component.html',
  styleUrls: ['./ownership.component.css']
})
export class OwnershipComponent implements OnInit {

  public data!: Ownership[];

  public load!:boolean;

  constructor(private _homeService: HomeService){

  }

  ngOnInit(): void {
    this.load = true;
    this._homeService.getAllHome()
    .subscribe(
      ((res) => {
        this.data = res.data
        this.load= false;
      })
    )
  }

}
