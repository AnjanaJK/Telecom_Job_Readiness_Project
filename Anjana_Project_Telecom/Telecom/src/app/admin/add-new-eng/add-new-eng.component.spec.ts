import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewEngComponent } from './add-new-eng.component';

describe('AddNewEngComponent', () => {
  let component: AddNewEngComponent;
  let fixture: ComponentFixture<AddNewEngComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddNewEngComponent]
    });
    fixture = TestBed.createComponent(AddNewEngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
