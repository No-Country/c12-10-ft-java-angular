import { AfterViewInit, Component, EventEmitter, OnDestroy, OnInit, Output, inject } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, Subject, debounceTime, distinctUntilChanged, filter, map, of, startWith, switchMap, takeUntil, tap } from 'rxjs';
import { NavigationExtras, Router, RouterLink } from '@angular/router';
import { HomeService } from '../../services/home-service.service';

@Component({
  selector: 'home-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']


})
export class HeaderComponent implements  AfterViewInit , OnDestroy {

  value='';
  @Output()
  public term = new EventEmitter();
  search = new FormControl();

  private _homeService = inject(HomeService)

  unsubscribe= new Subject();

  constructor(
    public router: Router,
    ){}


  ngAfterViewInit() {
    this.getValue()
  }

      /**
     * On destroy
     */

  ngOnDestroy(): void {
    this.unsubscribe.next(this.search)
    this.unsubscribe.complete();
  }


  getValue(){
    this.search.valueChanges
      .pipe(
        takeUntil(this.unsubscribe),
        debounceTime(500),
        distinctUntilChanged())
      .subscribe((res) => {
        if(!res) return;
        this.router.navigate([`/${res}`])
      })
  }



}










