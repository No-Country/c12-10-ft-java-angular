import { Component, Input } from '@angular/core';
import { Review } from '../../interfaces/review.interface';

@Component({
  selector: 'home-detail-review',
  templateUrl: './detail-review.component.html',
  styleUrls: ['./detail-review.component.css']
})
export class DetailReviewComponent {

  @Input() public review!:Review

  profile: string = '../../../assets/images/profile.png';
  imageUrl: string = '../../../assets/images/departamento2.jpg'

}
