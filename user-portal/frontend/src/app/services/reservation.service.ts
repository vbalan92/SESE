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
  private reservationUrl = './api/reservations';

  constructor(private http: HttpClient) {
  }

  reserveRoom(reservation: ReservationDTO): Observable<ReservationDTO> {
    reservation.fromDate = this.getDateInMillis(reservation.fromDate);
    reservation.toDate = this.getDateInMillis(reservation.toDate);
    reservation.customerDateOfBirth = this.getDateInMillis(reservation.customerDateOfBirth);
    return this.http.post<ReservationDTO>(this.reservationUrl, reservation, httpOptions);
  }

  private getDateInMillis(date: any) {
    let date2 = new Date(Date.UTC(date.year, date.month - 1, date.day));
    return date2.getTime();
  }

  findAll(): Observable<ReservationDTO[]> {
    return this.http.get<ReservationDTO[]>(this.reservationUrl, httpOptions);
  }
}
