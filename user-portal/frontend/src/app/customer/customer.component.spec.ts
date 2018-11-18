import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerComponent } from './customer.component';
import {expect} from '@angular/platform-browser/testing/src/matchers';
import {describe} from '@angular/core/testing/src/testing_internal';

describe('CustomerComponent', () => {
  let component: CustomerComponent;
  let fixture: ComponentFixture<CustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
