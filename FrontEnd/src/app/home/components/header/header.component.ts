import { AfterViewInit, Component, EventEmitter, OnInit, Output, inject } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, debounceTime, distinctUntilChanged, filter, map, of, startWith, switchMap, tap } from 'rxjs';
import { NavigationExtras, Router, RouterLink } from '@angular/router';
import { HomeService } from '../../services/home-service.service';

@Component({
  selector: 'home-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']


})
export class HeaderComponent  {

  value='';
  @Output()
  public term = new EventEmitter();
  search = new FormControl();

  private _homeService = inject(HomeService)

  constructor(
    public router: Router,
    ){}


    ngAfterViewInit() {
      this.search.valueChanges
      .pipe(
        debounceTime(400),
        distinctUntilChanged())
      .subscribe((res) => {
        if(!res) return;
        this.router.navigate([`/${res}`])
      })
    }



}










