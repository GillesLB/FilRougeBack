import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabArmeComponent } from './tab-arme.component';

describe('TabArmeComponent', () => {
  let component: TabArmeComponent;
  let fixture: ComponentFixture<TabArmeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabArmeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabArmeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
