import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Ownership, TypeOfHouse } from '../interfaces/Ownership';
import { CSSIcons, Service } from '../interfaces/Service';

@Injectable({
  providedIn: 'root'
})
export class OwnershipService {
  ownership: Ownership = {
    id: '',
    createAt: null,
    modifiedAt: null,
    country: '',
    state: '',
    city: '',
    address: '',
    images: [],
    house_type: TypeOfHouse.APARTMENT,
    rooms: 1,
    bathrooms: 1,
    house_area: 1,
    description: '',
    price: 1,
    deposit: 0,
    payment_conditions: '',
    additional_services: [],
    additional_fees: [],
    policies_cancellation: '30-day notice required',
    latitude: 0,
    longitude: 0,
    pets_allowed: false,
    smoking_policy: '',
    available_date: 0
  }
  services: Service[] = [
    {
      title: 'Comida',
      icon: CSSIcons.UTENSILS,
      activate: false
    },
    {
      title: 'Piscina',
      icon: CSSIcons.WATER_LADDER,
      activate: false
    },
    {
      title: 'Internet',
      icon:  CSSIcons.WIFI,
      activate: false
    },
    {
      title: 'Mascotas',
      icon: CSSIcons.SHIELD_DOG,
      activate: false
    },
    {
      title: 'No fumar',
      icon: CSSIcons.BAN_SMOKING,
      activate: false
    },
    {
      title: 'Estacionamiento',
      icon: CSSIcons.CAR_SIDE,
      activate: false
    },
    {
      title: 'Gym',
      icon:  CSSIcons.DUMBBELL,
      activate: false
    }
  ]
  types = [
    {
      type: TypeOfHouse.HOUSE,
      title: 'Casa',
      description: 'Los huespedes disponen del alojamiento entero para ellos',
      activate: false
    },
    {
      type: TypeOfHouse.CABIN,
      title: 'Cabaña',
      description: 'Los huespedes disponen del alojamiento entero para ellos',
      activate: false
    },
    {
      type: TypeOfHouse.APARTMENT,
      title: 'Departamento',
      description: 'Los huespedes disponen del alojamiento entero para ellos',
      activate: false
    }
  ]
  public _typeOfHouse: BehaviorSubject<any> = new BehaviorSubject<any>(this.types);
  public _ownership: BehaviorSubject<Ownership> = new BehaviorSubject<Ownership>(this.ownership);
 
}
