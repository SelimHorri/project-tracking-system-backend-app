import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerIndexComponent } from './manager-index.component';

describe('ManagerIndexComponent', () => {
  let component: ManagerIndexComponent;
  let fixture: ComponentFixture<ManagerIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerIndexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
