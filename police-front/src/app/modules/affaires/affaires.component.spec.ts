import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffairesComponent } from './affaires.component';

describe('AffairesComponent', () => {
  let component: AffairesComponent;
  let fixture: ComponentFixture<AffairesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffairesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffairesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
