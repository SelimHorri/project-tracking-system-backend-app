import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeTeamComponent } from './employee-team.component';

describe('EmployeeTeamComponent', () => {
  let component: EmployeeTeamComponent;
  let fixture: ComponentFixture<EmployeeTeamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeTeamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
