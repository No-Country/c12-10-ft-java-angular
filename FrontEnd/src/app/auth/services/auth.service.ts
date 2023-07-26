import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { User } from 'src/app/auth/interfaces/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private _http: HttpClient) { }
  register(user: User) {
    return this._http.post(`${environment.apiUrl}/user/create`, user)
  }
  login(user: User) {
    return this._http.post(`${environment.apiUrl}/user/login`, user)

  }
}
