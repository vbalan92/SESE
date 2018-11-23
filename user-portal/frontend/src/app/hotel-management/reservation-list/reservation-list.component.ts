import {Component, OnInit} from '@angular/core';
import {ReservationDTO} from '../room-list/models/reservation';
import {ReservationService} from '../../services/reservation.service';
import {ReservationDetailDTO} from "./reservation-list-item/models/reservation.dto";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {

  reservations: ReservationDetailDTO[];

  constructor(private reservationService: ReservationService) {
  }

  ngOnInit() {
    this.reservationService.findAll().subscribe(
      reservations => {
        this.reservations = reservations;
      }
    );
  }
}
