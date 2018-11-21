import {Component, Input, OnInit} from '@angular/core';
import {ReservationDetailDTO} from "./models/reservation.dto";

@Component({
  selector: 'app-reservation-list-item',
  templateUrl: './reservation-list-item.component.html',
  styleUrls: ['./reservation-list-item.component.css']
})
export class ReservationListItemComponent implements OnInit {

  @Input()
  reservation: ReservationDetailDTO;

  constructor() {
  }

  ngOnInit() {
  }

}
