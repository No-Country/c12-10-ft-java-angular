import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/home/interfaces/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private _http: HttpClient) { }
  register(user: User) {
    return this._http.post('https://nocountry-production-78d6.up.railway.app/user', user)
  }
}
