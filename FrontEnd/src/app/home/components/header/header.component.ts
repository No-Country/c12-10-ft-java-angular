import { AfterViewInit, Component, EventEmitter, OnDestroy, OnInit, Output, inject } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, Subject, debounceTime, distinctUntilChanged, filter, map, of, startWith, switchMap, takeUntil, tap } from 'rxjs';
import { NavigationExtras, Router, RouterLink } from '@angular/router';
import { HomeService } from '../../services/home-service.service';
import { AuthService } from 'src/app/auth/services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'home-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']


})
export class HeaderComponent implements  AfterViewInit , OnDestroy {

  value='';
  @Output()
  tuobjeto: Object[] = [{}]
  public term = new EventEmitter();
  search = new FormControl();

  private _homeService = inject(HomeService)
  showLogin: string
  unsubscribe= new Subject();

  constructor(public router: Router, private authService: AuthService, private _snackBar: MatSnackBar){
    this.showLogin = this.authService.subjectIsLogged    
  }


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


  getValue() {    
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
  show() {
    console.log(this.authService.subjectIsLogged);
    if(this.authService.subjectIsLogged) {
      this.router.navigate(['/property-register'])
    } else {
      const snackBarRef = this._snackBar.open('Debes iniciar sesión primero', 'Aceptar', {
        verticalPosition: 'top',
        panelClass: ['error-snackbar'],
        duration: 2000,
      });
      snackBarRef.onAction().subscribe(() => {
        this.router.navigate(['/auth/signin']);
      });
    }
  }
  logout() {
    window.localStorage.removeItem('userId')
    window.location.reload()
  }


}










