import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Customer } from '../models/customer.model';
import { CustomerService } from './customer.service';

@Component({
  templateUrl: './details-customer.component.html'
})
export class AddCustomerComponent {

  selectedCustomer: Customer = new Customer();

  constructor(private router: Router, private customerService: CustomerService) {

  }

  detailsCustomer(): void {
    this.customerService.getCustomer(this.selectedCustomer)
      .subscribe( data => {
        this.gotoCustomers();
        alert('Customer updated successfully.');
      });

  }


  updateCustomer(): void {
    this.customerService.updateCustomer(this.selectedCustomer)
      .subscribe( data => {
        this.gotoCustomers();
        alert('Customer updated successfully.');
      });

  }

  deleteCustomer(customer: Customer): void {
    this.customerService.getCustomer(customer)
      .subscribe( data => {
        this.selectedCustomer = <Customer>data;
      });
  }

  gotoCustomers() {
    this.router.navigate(['/details']);
  }

}
