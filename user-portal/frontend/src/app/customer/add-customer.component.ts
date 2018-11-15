import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';

import { Customer } from '../models/customer.model';
import { CustomerService } from './customer.service';

@Component({
  templateUrl: './add-customer.component.html'
})
export class AddCustomerComponent implements  OnInit {

  customer: Customer = new Customer();

  constructor(private router: Router, private customerService: CustomerService) {
  }

  createCustomer(): void {
    this.customerService.createCustomer(this.customer)
        .subscribe( data => {
          this.gotoCustomers();
          alert('Customer created successfully.');
        });
  }

  ngOnInit(){
  }

  gotoCustomers() {
    this.router.navigate(['/customers']);
  }

}
