import { Component } from '@angular/core';
import { Ownership } from '../../interfaces/Ownership';
import { OwnershipService } from '../../services/ownership.service';

@Component({
  selector: 'app-property-register-images',
  templateUrl: './property-register-images.component.html',
  styleUrls: ['./property-register-images.component.css']
})

export class PropertyRegisterImagesComponent {
  images: string[] = []
  ownership!: Ownership
  constructor(private ownershipService: OwnershipService) {
    ownershipService._ownership.subscribe((data: Ownership) => {
      this.ownership = data     
      if('images' in data) {
        this.images = data.images
      }
    })
  }
  onFileSelected(event: any) {
    if(this.images.length < 2) {
      const file = event.target.files[0];
      const reader = new FileReader();
      reader.onload = () => {
        this.images.push(reader.result as string);
        this.ownership.images = this.images
        this.ownershipService._ownership.next(this.ownership)
      };
      reader.readAsDataURL(file);
    }
  }
  removeImage(image: string) {
    const newImages = this.images.filter((value: string) => value != image)
    this.images = newImages
    this.ownership.images = this.images
    this.ownershipService._ownership.next(this.ownership)
  }
}
