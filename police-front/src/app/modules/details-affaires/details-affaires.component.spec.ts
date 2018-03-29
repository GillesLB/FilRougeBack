import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsAffairesComponent } from './details-affaires.component';

describe('DetailsAffairesComponent', () => {
  let component: DetailsAffairesComponent;
  let fixture: ComponentFixture<DetailsAffairesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsAffairesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsAffairesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
