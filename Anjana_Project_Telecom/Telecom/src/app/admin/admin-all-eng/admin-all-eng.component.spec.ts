import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllEngComponent } from './admin-all-eng.component';

describe('AdminAllEngComponent', () => {
  let component: AdminAllEngComponent;
  let fixture: ComponentFixture<AdminAllEngComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminAllEngComponent]
    });
    fixture = TestBed.createComponent(AdminAllEngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
