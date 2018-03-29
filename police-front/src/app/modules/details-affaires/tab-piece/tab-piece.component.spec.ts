import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabPieceComponent } from './tab-piece.component';

describe('TabPieceComponent', () => {
  let component: TabPieceComponent;
  let fixture: ComponentFixture<TabPieceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabPieceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabPieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
