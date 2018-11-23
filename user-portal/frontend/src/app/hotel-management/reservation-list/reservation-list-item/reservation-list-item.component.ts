import {Component, Input, OnInit} from '@angular/core';
import {ReservationDetailDTO} from './models/reservation.dto';
import {ReservationService} from '../../../services/reservation.service';
import {ReservationStatus} from '../../room-list/models/reservation';

@Component({
  selector: 'app-reservation-list-item',
  templateUrl: './reservation-list-item.component.html',
  styleUrls: ['./reservation-list-item.component.css']
})
export class ReservationListItemComponent implements OnInit {

  @Input()
  reservation: ReservationDetailDTO;

  constructor(private reservationService: ReservationService) {
  }

  ngOnInit() {
  }

  cancelReservation(): void {
    console.log('reservation cancelled!');
    this.reservation.status = ReservationStatus.CANCELLED;
    this.reservationService.update(this.reservation).subscribe((data: ReservationDetailDTO) => {
      this.reservation = data ;
    });
  }

  approveReservation(): void {
    console.log('reservation approved!');
    this.reservation.status = ReservationStatus.CONFIRMED;
    this.reservationService.update(this.reservation).subscribe((data: ReservationDetailDTO) => {
      this.reservation = data ;
    });
  }

  get reservationStatus(): string {
    if (this.reservation.status === ReservationStatus.CONFIRMED) {
      return 'Bestätigt';
    } else if (this.reservation.status === ReservationStatus.CANCELLED) {
      return 'Storniert';
    }
    return 'Neu';
  }

  // detailReservation(): void {
  //   console.log('reservation approved!');
  //   this.reservation.status = Status.DELETED;
  //   this.reservation.id = this.reservation.id;
  //   this.reservationService.update(this.reservation).subscribe((data: ReservationDetailDTO) => {
  //     this.reservation = data ;
  //   });
  // }
}
