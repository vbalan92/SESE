import {Component, Input, OnInit} from '@angular/core';
import {ReservationDTO} from "../room-list/models/reservation";

@Component({
  selector: 'app-reservation-detail',
  templateUrl: './reservation-detail.component.html',
  styleUrls: ['./reservation-detail.component.css']
})
export class ReservationDetailComponent implements OnInit {

  @Input()
  private reservation: ReservationDTO;

  constructor() {
  }

  ngOnInit() {
  }

}
