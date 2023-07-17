import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, delay, tap } from 'rxjs';
import { Homes, Country } from '../interface/home.interface';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HomeService {



  constructor(private _http: HttpClient) { }

  // getHomes(queryParams:any): Observable<newHome[]>{
  //   return this._http.get<newHome[]>(`${environment.apiUrl}/home`,  {params: queryParams})
  // }

  getHomesByCountry(country:any): Observable<Homes> {
    return this._http.get<Homes>(`${environment.apiUrl}/ownership/listAllOwnershipByCountry/${country}`)
  }

  getAllHome():Observable<Homes> {
    return this._http.get<Homes>(`${environment.apiUrl}/ownership/`)
  }

}

