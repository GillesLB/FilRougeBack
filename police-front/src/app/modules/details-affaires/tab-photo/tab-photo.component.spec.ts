import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabPhotoComponent } from './tab-photo.component';

describe('TabPhotoComponent', () => {
  let component: TabPhotoComponent;
  let fixture: ComponentFixture<TabPhotoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabPhotoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabPhotoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
