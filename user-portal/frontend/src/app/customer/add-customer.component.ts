import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Customer} from '../models/customer.model';
import {CustomerService} from './customer.service';
import {Address} from "../models/address.model";

@Component({
  selector: 'app-add-costomer-component',
  templateUrl: './add-customer.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AddCustomerComponent implements OnInit {

  customer: Customer = new Customer();

  constructor(private router: Router, private customerService: CustomerService) {
    this.customer.billAddress = new Address();
  }

  createCustomer(): void {
    this.customerService.createCustomer(this.customer)
      .subscribe(data => {
        this.gotoCustomers();
        alert('Customer created successfully.');
      });
  }

  ngOnInit() {
  }

  gotoCustomers() {
    this.router.navigate(['/customers']);
  }

}
