import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PastQuizzesComponent } from './past-quizzes.component';

describe('PastQuizzesComponent', () => {
  let component: PastQuizzesComponent;
  let fixture: ComponentFixture<PastQuizzesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PastQuizzesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PastQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
