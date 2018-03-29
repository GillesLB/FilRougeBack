import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAffairesComponent } from './add-affaires.component';

describe('AddAffairesComponent', () => {
  let component: AddAffairesComponent;
  let fixture: ComponentFixture<AddAffairesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAffairesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAffairesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
