import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentQuizzesComponent } from './current-quizzes.component';

describe('CurrentQuizzesComponent', () => {
  let component: CurrentQuizzesComponent;
  let fixture: ComponentFixture<CurrentQuizzesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrentQuizzesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
