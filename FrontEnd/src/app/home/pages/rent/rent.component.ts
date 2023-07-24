import { AfterViewInit, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { HomeService } from '../../services/home-service.service';
import { Observable, filter, map, switchMap, tap } from 'rxjs';
import { Ownership } from '../../interfaces/home.interface';
import { Picture } from '../../interfaces/picture.interface';
import { FormBuilder, Validators } from '@angular/forms';
import { Review } from '../../interfaces/review.interface';
import {MediaMatcher} from '@angular/cdk/layout'

@Component({
  selector: 'app-rent',
  templateUrl: './rent.component.html',
  styleUrls: ['./rent.component.css']
})
export class RentComponent implements OnInit, AfterViewInit {

  profile: string = '../../../assets/images/profile.png';
  imageUrl: string = '../../../assets/images/departamento2.jpg';
  homes:Ownership[] = [];

  homes$!: Observable<any>;
  id: any;
  home!: Ownership;
  pictures!:string[];
  newPictures!: string[];
  principalPicture!: string
  homeFound!:Ownership;

  reviews!: Review[];

  public mobileQuery!: MediaQueryList;

  private _mobileQueryListener: () => void;

  constructor(
    private _activeRouter: ActivatedRoute,
    private _homeService: HomeService,
    private _formBuilder: FormBuilder,
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher

  )
  {

    this.getId();

    this.mobileQuery = media.matchMedia('(min-width: 768px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);

  }

  ngOnInit(): void{
    console.log(this.id)
    this.getHomes();
    this.getPictures(this.id);
    this.getReviewByOwnerShip(this.id);
    console.log(this.home)


  }

  ngAfterViewInit(): void {
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
      this.home= this.homes.find((el) => el.id === this.id) ? this.homes.find((el) => el.id === this.id) : [] as any;
      //console.log(this.home, 'home=> get home');
    })
  }

  getPictures(id:string): void {
    console.log(id, 'id en picture')
    this._homeService.getPictureOwnership(id)
      .subscribe((res) =>  {
        this.pictures = res.data.images;
        this.principalPicture = this.pictures[0];
        this.newPictures = this.pictures.slice(1,5);
      });
    }

    getReviewByOwnerShip(id:string) {
      this._homeService.getReviewByOwnewShip(id).subscribe(
        (res) => {
          this.reviews = res.data;
        }
      )
    }



    getSuperAnfitrion():void {

    }
  // firstFormGroup = this._formBuilder.group({
  //   firstCtrl: ['', Validators.required],
  // });
  // secondFormGroup = this._formBuilder.group({
  //   secondCtrl: ['', Validators.required],
  // });
  // isLinear = false;
  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }
}







