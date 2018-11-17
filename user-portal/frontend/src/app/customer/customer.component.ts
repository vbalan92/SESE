import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Customer} from '../models/customer.model';
import {CustomerService} from './customer.service';
import {Address} from "../models/address.model";

@Component({
  changeDetection: ChangeDetectionStrategy.Default,
  selector: 'app-customer-list',
  templateUrl: './customer.component.html',
  styles: []
})
export class CustomerComponent implements OnInit {

  customers: Customer[];
  showDetail: boolean;
  selectedCustomer: Customer;
  searchCustomer: Customer;

  constructor(private router: Router, private customerService: CustomerService) {
    this.searchCustomer = new Customer();
  }

  ngOnInit() {
    this.showDetail = false;
    this.customerService.getCustomers()
      .subscribe(data => {
        this.customers = data;
      });
  }

  search() {
    if (this.searchCustomer.id) {
      this.customers.filter(item => item.id === this.searchCustomer.id);
    }
    if (this.searchCustomer.email) {
      this.customers.filter(item => item.email === this.searchCustomer.email);
    }
  }


  deleteCustomer(customer: Customer): void {
    this.customerService.deleteCustomer(customer)
      .subscribe(data => {
        this.customers = this.customers.filter(u => u !== customer);
      });
  }

  detailCustomer(customer: Customer): void {
    this.showDetail = true;
    this.selectedCustomer = customer;

  }



}
