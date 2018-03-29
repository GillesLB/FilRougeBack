import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabVehiculeComponent } from './tab-vehicule.component';

describe('TabVehiculeComponent', () => {
  let component: TabVehiculeComponent;
  let fixture: ComponentFixture<TabVehiculeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabVehiculeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabVehiculeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
