import {
  ChangeDetectionStrategy, ChangeDetectorRef, Component, Directive, EventEmitter, Input, OnInit,
  Output
} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

import {Customer} from '../models/customer.model';
import {CustomerService} from './customer.service';
import {switchMap} from "rxjs/internal/operators";
import {Observable} from "rxjs/index";

@Component({
  templateUrl: './details-customer.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class DetailsCustomerComponent implements OnInit {
  selectedId: number;
  selectedCustomer: Customer;

  constructor(private route: ActivatedRoute, private router: Router, private customerService: CustomerService) {
  }

  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.selectedId = id;
    this.getCustomer(id);
  }

  change($event) {
    this.selectedCustomer.fax = $event.target.value;
  }

  updateCustomer(): void {
    this.customerService.updateCustomer(this.selectedCustomer)
      .subscribe(data => {
        this.gotoCustomers();
        alert('Customer updated successfully.');
      });
  }


  getCustomer(id): void {
    this.customerService.getCustomerWithId(id).subscribe((customer: Customer) => {
        this.selectedCustomer = customer;
      },
      (exception: any) => {
        console.log('Error');
      },
      () => {
        console.log('SERVICE CALL completed');
      }
    );
  }

  gotoCustomers() {
    this.router.navigate(['/customerDetails']);
  }

}
