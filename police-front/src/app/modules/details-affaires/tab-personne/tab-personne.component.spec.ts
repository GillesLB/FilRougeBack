import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabPersonneComponent } from './tab-personne.component';

describe('TabPersonneComponent', () => {
  let component: TabPersonneComponent;
  let fixture: ComponentFixture<TabPersonneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabPersonneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
