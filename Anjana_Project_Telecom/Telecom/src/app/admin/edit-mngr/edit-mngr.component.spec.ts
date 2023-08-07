import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMngrComponent } from './edit-mngr.component';

describe('EditMngrComponent', () => {
  let component: EditMngrComponent;
  let fixture: ComponentFixture<EditMngrComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditMngrComponent]
    });
    fixture = TestBed.createComponent(EditMngrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
