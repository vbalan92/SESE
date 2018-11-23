import {Component, OnInit} from '@angular/core';
import {ReservationDTO} from '../room-list/models/reservation';
import {ReservationService} from '../../services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {

  reservations: ReservationDTO[];

  // searchReservationDetailDTO: ReservationDetailDTO;
  // status = Status;
  // keys: Status[];
  // TODO Abbas 2nd constructor ?!
  // constructor() {
  //  this.keys = Object.keys(this.status);
  // }
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
    // this.reservations.filter(item => item.roomName === this.searchReservationDetailDTO.roomName ||
    //   item.roomName === this.searchReservationDetailDTO.roomName ||
    //   item.status === this.searchReservationDetailDTO.status ||
    //   item.fromDate === this.searchReservationDetailDTO.fromDate);
  }
}
