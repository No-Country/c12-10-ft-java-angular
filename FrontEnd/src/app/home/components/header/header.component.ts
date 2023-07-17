import { AfterViewInit, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, debounceTime, map, of, startWith, tap } from 'rxjs';
import { NavigationExtras, Router, RouterLink } from '@angular/router';

@Component({
  selector: 'home-header',
  templateUrl: './header.component.html',

})
export class HeaderComponent  {

  @Output()
  public term = new EventEmitter();
  search = new FormControl();

  constructor(
    public router: Router,
    ){}


    ngAfterViewInit() {
      this.search.valueChanges
      .pipe(
        debounceTime(500))
      .subscribe((val:any) => {
        if(!val) return;
        this.router.navigate([`list/${val}`])
        });
      }
}










