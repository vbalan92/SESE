import {Component, OnInit} from '@angular/core';
import {ReservationDTO, ReservationStatus} from '../room-list/models/reservation';
import {ReservationService} from '../../services/reservation.service';
import {ReservationDetailDTO} from './reservation-list-item/models/reservation.dto';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {

  reservations: ReservationDetailDTO[];
  searchReservationDetailDTO: ReservationDetailDTO = new ReservationDetailDTO();
  cachedReservations: ReservationDetailDTO[];

  constructor(private reservationService: ReservationService) {
  }

  ngOnInit() {
    this.reservationService.findAll().subscribe(
      (reservations: ReservationDetailDTO[]) => {
        this.reservations = reservations;
        this.cachedReservations = this.reservations;
      }
    );
  }

  search() {
    this.reservations.filter(item => item.roomName === this.searchReservationDetailDTO.roomName ||
      item.customerName === this.searchReservationDetailDTO.customerName ||
      item.customerEmail === this.searchReservationDetailDTO.customerName ||
      item.status === this.searchReservationDetailDTO.status);
  }

  resetSearch() {
    this.reservations = this.cachedReservations;
    this.searchReservationDetailDTO.customerEmail = null;
    this.searchReservationDetailDTO.customerName = null;
    this.searchReservationDetailDTO.roomName = null;
    this.searchReservationDetailDTO.status = null;
  }
}
