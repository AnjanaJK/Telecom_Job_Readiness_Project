import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewMngrComponent } from './add-new-mngr.component';

describe('AddNewMngrComponent', () => {
  let component: AddNewMngrComponent;
  let fixture: ComponentFixture<AddNewMngrComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddNewMngrComponent]
    });
    fixture = TestBed.createComponent(AddNewMngrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
