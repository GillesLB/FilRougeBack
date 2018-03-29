import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableCrudPersonneComponent } from './table-crud-personne.component';

describe('TableCrudPersonneComponent', () => {
  let component: TableCrudPersonneComponent;
  let fixture: ComponentFixture<TableCrudPersonneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableCrudPersonneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableCrudPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
