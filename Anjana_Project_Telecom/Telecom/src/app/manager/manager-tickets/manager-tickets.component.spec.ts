import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerTicketsComponent } from './manager-tickets.component';

describe('ManagerTicketsComponent', () => {
  let component: ManagerTicketsComponent;
  let fixture: ComponentFixture<ManagerTicketsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManagerTicketsComponent]
    });
    fixture = TestBed.createComponent(ManagerTicketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
