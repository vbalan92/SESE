import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Customer} from '../../models/customer.model';
import {Router} from '@angular/router';
import {CustomerService} from '../../services/customer.service';

@Component({
  changeDetection: ChangeDetectionStrategy.Default,
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[];
  cachedCustomers: Customer[];
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
        this.cachedCustomers = this.customers;
      });
  }

  search() {
    if (this.searchCustomer) {
      this.customers = this.customers.filter(
        item => item.email === this.searchCustomer.email || item.lastName === this.searchCustomer.lastName);
    }
  }

  resetSearch() {
    this.customers = this.cachedCustomers;
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
