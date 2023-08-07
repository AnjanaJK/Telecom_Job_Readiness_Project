import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllMngrComponent } from './admin-all-mngr.component';

describe('AdminAllMngrComponent', () => {
  let component: AdminAllMngrComponent;
  let fixture: ComponentFixture<AdminAllMngrComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminAllMngrComponent]
    });
    fixture = TestBed.createComponent(AdminAllMngrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
