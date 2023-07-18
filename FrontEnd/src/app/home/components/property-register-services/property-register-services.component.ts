import { Component } from '@angular/core';
import { CSSIcons, Service } from '../../interfaces/Service';
import { OwnershipService } from '../../services/ownership.service';
import { Ownership } from '../../interfaces/Ownership';

@Component({
  selector: 'app-property-register-services',
  templateUrl: './property-register-services.component.html',
  styleUrls: ['./property-register-services.component.css']
})
export class PropertyRegisterServicesComponent {
  services: Service[]
  ownership!: Ownership

  constructor(private ownershipService: OwnershipService) {
    this.services = this.ownershipService.services
    ownershipService._ownership.subscribe((data) => {
      this.ownership = data
    })
  }

  activate(service: Service) {
    service.activate = !service.activate
    let smoking_policy
    let pets_allowed = false
    const filteredIcons = this.services.filter((service: Service) => {
      if (service.icon === CSSIcons.BAN_SMOKING && service.activate) {
        smoking_policy = 'No smoking'
      } else if (service.icon === CSSIcons.BAN_SMOKING && !service.activate) {
        smoking_policy = 'se permite'
      }
      if (service.icon === CSSIcons.SHIELD_DOG && service.activate) {
        pets_allowed = true
      } else if (service.icon === CSSIcons.SHIELD_DOG && !service.activate) {
        pets_allowed = false
      }
      if (service.activate && service.icon !== CSSIcons.BAN_SMOKING && service.icon !== CSSIcons.SHIELD_DOG) {
        return service
      }
      return
    })
    if (smoking_policy) {
      this.ownership.smoking_policy = smoking_policy
    }
    if (pets_allowed != null) {
      this.ownership.pets_allowed = pets_allowed
    }
    this.ownership.additional_services = filteredIcons
    this.ownershipService._ownership.next(this.ownership)
    console.log(this.ownership);
  }
}
