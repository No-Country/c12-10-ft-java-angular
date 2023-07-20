import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { HomeService } from '../../services/home-service.service';
import { Observable, filter, map, switchMap, tap } from 'rxjs';
import { Ownership } from '../../interfaces/home.interface';
import { Picture } from '../../interfaces/picture.interface';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-rent',
  templateUrl: './rent.component.html',
  styleUrls: ['./rent.component.css']
})
export class RentComponent implements OnInit, AfterViewInit {
  imageUrl: string = '../../../assets/images/departamento2.jpg'
  profile: string = '../../../assets/images/profile.png'

  homes:Ownership[] = [];

  homes$!: Observable<any>;
  id: any
  home!: Ownership[];
  picture!:Picture;
  homeFound!:Ownership


  constructor(
    private _activeRouter: ActivatedRoute,
    private _homeService: HomeService,
    private _formBuilder: FormBuilder,

  ){
    this.getId();
  }

  // ngOnInit(): void {

  // this.homes$ = this._homeService.getAllHome();

  //  const resul = this._activeRouter.params
  //  .pipe(
  //   switchMap((params) => this.homes$
  //   .pipe(
  //     map((res) => res.filter(res.id === params))))
  //  ).subscribe((home) =>  console.log(home))
  // }

  ngOnInit(): void{
    console.log(this.id)
    this.getHomes();
    this.getPictures(this.id);
  }

  ngAfterViewInit(): void {
    console.log(this.home, 'afterViewInit');

    console.log(this.picture, 'getPicture');
  }

  getId():void {
    this._activeRouter.params
    .subscribe(({id}) => {
     this.id = id;
    });

  }

  getHomes(): void {
    this._homeService.getAllHome().subscribe(r => {
      this.homes = r.data
      this.home= this.homes.filter((el) => el.id === this.id)
      console.log(this.home, 'home')
    })
  }

  getPictures(id:string): void {
    console.log(id, 'id en picture')
    this._homeService.getPictureOwnership(id).pipe(tap(console.log)).subscribe((res) =>  {
      this.picture = res.data;
      console.log('picture ==>', this.picture)
    });
    }

  // firstFormGroup = this._formBuilder.group({
  //   firstCtrl: ['', Validators.required],
  // });
  // secondFormGroup = this._formBuilder.group({
  //   secondCtrl: ['', Validators.required],
  // });
  // isLinear = false;

}





