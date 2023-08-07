import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EngineerDashComponent } from './engineer-dash.component';

describe('EngineerDashComponent', () => {
  let component: EngineerDashComponent;
  let fixture: ComponentFixture<EngineerDashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EngineerDashComponent]
    });
    fixture = TestBed.createComponent(EngineerDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
