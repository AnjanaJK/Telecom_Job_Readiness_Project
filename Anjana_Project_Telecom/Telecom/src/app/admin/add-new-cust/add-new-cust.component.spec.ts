import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewCustComponent } from './add-new-cust.component';

describe('AddNewCustComponent', () => {
  let component: AddNewCustComponent;
  let fixture: ComponentFixture<AddNewCustComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddNewCustComponent]
    });
    fixture = TestBed.createComponent(AddNewCustComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
