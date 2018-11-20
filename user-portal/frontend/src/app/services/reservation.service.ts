import {Injectable} from '@angular/core';
import {ReservationDTO} from "../hotel-management/room-list/models/reservation";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private reservationUrl = '/reservations';

  constructor(private http: HttpClient) {
  }

  reserveRoom(reservation: ReservationDTO): Observable<ReservationDTO> {
    return this.http.post<ReservationDTO>(this.reservationUrl, reservation, httpOptions);
  }
}
