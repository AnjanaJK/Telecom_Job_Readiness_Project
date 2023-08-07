import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllCustComponent } from './admin-all-cust.component';

describe('AdminAllCustComponent', () => {
  let component: AdminAllCustComponent;
  let fixture: ComponentFixture<AdminAllCustComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminAllCustComponent]
    });
    fixture = TestBed.createComponent(AdminAllCustComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
