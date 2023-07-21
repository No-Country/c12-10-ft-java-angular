import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterReviewComponent } from './register-review.component';

describe('RegisterReviewComponent', () => {
  let component: RegisterReviewComponent;
  let fixture: ComponentFixture<RegisterReviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterReviewComponent]
    });
    fixture = TestBed.createComponent(RegisterReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
