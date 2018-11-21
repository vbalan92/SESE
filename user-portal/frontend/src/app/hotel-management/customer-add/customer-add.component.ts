import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Customer} from '../../models/customer.model';
import {CustomerService} from '../../services/customer.service';
import {Address} from "../../models/address.model";



@Component({
  selector: 'app-add-costomer-component',
  templateUrl: './customer-add.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerAddComponent implements OnInit {

  customer: Customer = new Customer();

  constructor(private router: Router, private customerService: CustomerService) {

  }

  createCustomer(): void {
    this.customerService.createCustomer(this.customer)
      .subscribe(data => {
        this.gotoCustomers();
        alert('Customer created successfully.');
      });
  }

  ngOnInit() {
    this.customer.billAddress = new Address();
  }

  gotoCustomers() {
    this.router.navigate(['/customers']);
  }

}
