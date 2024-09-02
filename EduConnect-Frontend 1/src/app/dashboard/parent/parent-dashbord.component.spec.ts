import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParentDashbordComponent } from './parent-dashbord.component';

describe('ParentTemplateComponent', () => {
  let component: ParentDashbordComponent;
  let fixture: ComponentFixture<ParentDashbordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ParentDashbordComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParentDashbordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
