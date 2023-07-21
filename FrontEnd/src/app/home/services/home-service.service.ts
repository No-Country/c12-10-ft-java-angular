import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, catchError, of } from 'rxjs';

import { environment } from 'src/environments/environment';
import { ResOwnership } from '../interfaces/home.interface';
import { respPicture } from '../interfaces/picture.interface';
import { respReview } from '../interfaces/review.interface';


@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private _value: Subject<string> = new Subject();


  constructor(private _http: HttpClient) { }


  getHomesByCountry(country:string): Observable<ResOwnership> {
    return this._http.get<ResOwnership>(`${environment.apiUrl}/ownership/listAllOwnershipByCountry/${country}`)

  }

  getAllHome():Observable<ResOwnership> {
    return this._http.get<ResOwnership>(`${environment.apiUrl}/ownership/`)
  }

  getPictureOwnership(id:string):Observable<respPicture> {
    return this._http.get<respPicture>(`${environment.apiUrl}/images/ownership/${id}`)
  }

  getReviewByOwnewShip(id:string):Observable<respReview> {
    return this._http.get<respReview>(`${environment.apiUrl}/reviews/ownership/${id}`)
  }

}
