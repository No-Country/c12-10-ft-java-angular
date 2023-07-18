import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/home/interfaces/User';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private _http: HttpClient) { }
  register(user: User) {
    return this._http.post(`${environment.apiUrl}/user`, user)
  }
}
