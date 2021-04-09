import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerTeamComponent } from './manager-team.component';

describe('ManagerTeamComponent', () => {
  let component: ManagerTeamComponent;
  let fixture: ComponentFixture<ManagerTeamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerTeamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
