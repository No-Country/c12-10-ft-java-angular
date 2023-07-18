import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Ownership } from '../../interfaces/Ownership';
import { OwnershipService } from '../../services/ownership.service';
import { errorMessage } from 'src/app/helpers/errors';

@Component({
  selector: 'app-property-register',
  templateUrl: './property-register.component.html',
  styleUrls: ['./property-register.component.css']
})
export class PropertyRegisterComponent {
  count = [1, 2, 3, 4, 5]
  dropDownCountry: boolean = false
  countries = ['Argentina', 'Peru', 'Colombia', 'Mexico']
  step: number = 1
  ownershipForm: FormGroup
  country: string = ''
  errorMessage = errorMessage
  ownership!: Ownership
  submitted: boolean = false
  disable: boolean = true
  constructor(private ownershipService: OwnershipService) {
    ownershipService._ownership.subscribe((data: Ownership) => {
      this.ownership = data
    })
    this.ownershipForm = new FormGroup({
      country: new FormControl('', [Validators.pattern('^[a-zA-Z]+$'), Validators.required]),
      address: new FormControl('', [Validators.pattern('^(?!^\\s+$)\\s*[A-Za-z\\s]+\\s*$'), Validators.required]),
      city: new FormControl('', [Validators.pattern('^(?!^\\s+$)\\s*[A-Za-z\\s]+\\s*$'), Validators.required]),
      price: new FormControl('', [Validators.pattern('^[0-9]+$'), Validators.required]),
      description: new FormControl('', [Validators.pattern('^(?!^\\s+$)\\s*[A-Za-z\\s]+\\s*$'), Validators.required]),
      bathrooms: new FormControl(1, [Validators.pattern('^[0-9]+$'), Validators.required]),
      rooms: new FormControl(1, [Validators.pattern('^[0-9]+$'), Validators.required]),
    })
    
  }
  public get f() { return this.ownershipForm.controls }
  nextStep() {
    this.submitted = true
    if(this.step == 4) {
      this.step += 1
      return 
    }
    console.log(this.ownership);
    if(this.step == 2) {
     if('house_type' in this.ownership) {
        this.disable = false
     }
    }
    if(this.step == 2 && this.disable) {
      return
    }
    if(this.ownershipForm.valid && this.ownershipForm.valid && this.step < 4) {
      this.step += 1
      this.ownershipService._ownership.next(this.ownershipForm.value)
    }
  }
  previousStep() {
    this.step -= 1
  }
  showCountries() {
    this.dropDownCountry = !this.dropDownCountry
  }
  selectCountry(value: string) {
    const countryControl = this.ownershipForm.get('country');
    if (countryControl) {
      countryControl.setValue(value);
    }
    this.country = value
    this.dropDownCountry = false
  }
  registerProperty() {
    let ownershipImages = this.ownership && this.ownership.images; 
    if (!ownershipImages || ownershipImages.length === 0) {
      console.log(ownershipImages, 'no contiene imágenes');
    } else {
      this.ownershipService.register(this.ownership).subscribe((data) => {
        console.log(data);
      })
      this.ownershipService.registerProperty(this.ownership).subscribe((data) => {
        console.log(data);
      })
      this.step += 1
    }
  }
}
