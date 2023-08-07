import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditEngComponent } from './edit-eng.component';

describe('EditEngComponent', () => {
  let component: EditEngComponent;
  let fixture: ComponentFixture<EditEngComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditEngComponent]
    });
    fixture = TestBed.createComponent(EditEngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
