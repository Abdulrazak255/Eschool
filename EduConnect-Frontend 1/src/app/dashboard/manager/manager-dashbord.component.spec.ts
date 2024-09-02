import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerDashbordComponent } from './manager-dashbord.component';

describe('ManagerTemplateComponent', () => {
  let component: ManagerDashbordComponent;
  let fixture: ComponentFixture<ManagerDashbordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManagerDashbordComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManagerDashbordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
