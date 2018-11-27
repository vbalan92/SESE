import {
  ChangeDetectionStrategy, ChangeDetectorRef, Component, Directive, EventEmitter, Input, OnInit,
  Output
} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerService} from '../../services/customer.service';
import {Customer} from '../../models/customer.model';
import {Address} from '../../models/address.model';
import {ReservationService} from '../../services/reservation.service';
import {ReservationDTO} from '../room-list/models/reservation';


@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  selector: 'app-details-customer-component',
  templateUrl: './customer-detail.component.html'
})

export class CustomerDetailComponent implements OnInit {
  @Input() model: Customer;
  showReservationBlock: boolean;
  showRoomBlock: boolean;
  reservations: ReservationDTO[];
  @Output() showDetail: EventEmitter<any> = new EventEmitter();


  constructor(private route: ActivatedRoute, private router: Router, private customerService: CustomerService, private  reservationService: ReservationService) {
    this.showReservationBlock = false;
    this.showRoomBlock = false;
  }

  ngOnInit() {
    if (!this.model.billAddress) {
      this.model.billAddress = new Address();
    }
  }

  change($event) {
    this.model.fax = $event.target.value;
  }

  updateCustomer(): void {
    this.customerService.updateCustomer(this.model)
      .subscribe(data => {
        this.goToCustomers();
        alert('Customer updated successfully.');
      });
  }

  goToCustomers() {
    this.router.navigate(['/customers']);
  }


  show() {
    this.reservationService.findAll().subscribe((data: ReservationDTO[]) => {
      this.reservations = data;
    }, (err) => {

    }, () => { // <----
      this.reservations = this.reservations.filter(item => item.customerEmail === this.model.email);
    });

    this.showRoomBlock = true;
    this.showReservationBlock = true;
  }

  /**
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
   **/
}




