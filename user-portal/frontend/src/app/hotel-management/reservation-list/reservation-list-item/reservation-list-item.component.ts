import {Component, Input, OnInit} from '@angular/core';
import {ReservationDetailDTO} from "./models/reservation.dto";
import {ReservationService} from "../../../services/reservation.service";

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
  }

  approveReservation(): void {
    console.log('reservation approved!');
  }
}
