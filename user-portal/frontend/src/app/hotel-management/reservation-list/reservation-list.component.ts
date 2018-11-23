import {Component, OnInit} from '@angular/core';
import {ReservationDTO, Status} from '../room-list/models/reservation';
import {ReservationService} from '../../services/reservation.service';
import {ReservationDetailDTO} from "./reservation-list-item/models/reservation.dto";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {

  reservations: ReservationDetailDTO[];

  searchReservationDetailDTO: ReservationDetailDTO;
  status = Status;
  keys: Status[];

  constructor() {
   this.keys = Object.keys(this.status);
  }
  constructor(private reservationService: ReservationService) {
  }

  ngOnInit() {
    this.reservationService.findAll().subscribe(
      reservations => {
        this.reservations = reservations;
      }
    );
  }

  searchReservations() {
    this.reservations.filter(item => item.roomName === this.searchReservationDetailDTO.roomName ||
      item.roomName === this.searchReservationDetailDTO.roomName ||
      item.status === this.searchReservationDetailDTO.status ||
      item.fromDate === this.searchReservationDetailDTO.fromDate);
  }
}
