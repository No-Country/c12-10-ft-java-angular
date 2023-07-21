import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent {
  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  isLinear = false;

  images:string[] = [
    'https://raw.githubusercontent.com/themesberg/flowbite/6b58ebaddb18d995e48dc12781645654f767b590/static/images/carousel/carousel-1.svg',
    'https://raw.githubusercontent.com/themesberg/flowbite/6b58ebaddb18d995e48dc12781645654f767b590/static/images/carousel/carousel-2.svg',
    'https://raw.githubusercontent.com/themesberg/flowbite/6b58ebaddb18d995e48dc12781645654f767b590/static/images/carousel/carousel-3.svg',
    'https://raw.githubusercontent.com/themesberg/flowbite/6b58ebaddb18d995e48dc12781645654f767b590/static/images/carousel/carousel-4.svg',
  ]

  constructor(private _formBuilder: FormBuilder) {}
}
