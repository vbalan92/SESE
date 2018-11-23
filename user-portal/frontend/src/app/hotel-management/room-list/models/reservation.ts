import {FormBuilder, FormControl, Validators} from '@angular/forms';

export enum Status {
  OPEN = 'OPEN',
  CANCELED = 'CANCELED',
  FINISHED = 'FINISHED',
  CONFIRMED = 'CONFIRMED',
  DELETED = 'DELETED'
}

export class ReservationDTO {
  id: number;
  roomId: number;
  customerName: string;
  customerEmail: string;
  customerDateOfBirth: any;
  fromDate: any;
  toDate: any;
  status: Status = Status.OPEN;
}

export class CreateReservationForm {
  customerName: FormControl;
  customerEmail: FormControl;
  customerDateOfBirth: FormControl;
  fromDate: FormControl;
  toDate: FormControl;
  status: FormControl;

  constructor(private auction: ReservationDTO, private fb: FormBuilder) {
    this.customerName = this.fb.control(this.auction.customerName, Validators.required);
    this.customerEmail = this.fb.control(this.auction.customerEmail, Validators.compose([Validators.email, Validators.required]));
    this.customerDateOfBirth = this.fb.control(this.auction.customerDateOfBirth, Validators.required);
    this.fromDate = this.fb.control(this.auction.fromDate);
    this.toDate = this.fb.control(this.auction.toDate);
    this.status = this.fb.control(this.auction.status);
  }
}
