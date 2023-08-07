import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerDashComponent } from './manager-dash.component';

describe('ManagerDashComponent', () => {
  let component: ManagerDashComponent;
  let fixture: ComponentFixture<ManagerDashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManagerDashComponent]
    });
    fixture = TestBed.createComponent(ManagerDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
