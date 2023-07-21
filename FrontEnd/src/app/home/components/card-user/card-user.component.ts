import { Component, Input } from '@angular/core';
import { Ownership } from '../../interfaces/home.interface';

@Component({
  selector: 'home-card-user',
  templateUrl: './card-user.component.html',
  styleUrls: ['./card-user.component.css']
})
export class CardUserComponent {

imageUrl: string = '../../../assets/images/departamento2.jpg'
profile: string = '../../../assets/images/profile.png'
@Input() public home!: Ownership
}
