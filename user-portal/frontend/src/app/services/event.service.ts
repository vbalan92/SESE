import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {EventDTO} from '../hotel-management/holiday-management/models/event-dto';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private eventUrl = './api/events';

  constructor(private http: HttpClient) { }

  public getEventWithId(id): Observable<any> {
    const url = this.eventUrl + '/' + id;
    return this.http.get(url);
  }

  public findAll(): Observable<any[]> {
    return this.http.get<EventDTO[]>(this.eventUrl);
  }

  public createHoliday(eventDTO): Observable<EventDTO>  {
    return this.http.post<EventDTO>(this.eventUrl, eventDTO);
  }

  public updateHoliday(eventDTO): Observable<any> {
    return this.http.put<EventDTO>(this.eventUrl + '/' + eventDTO.id , eventDTO);
  }

  public deleteHoliday(eventDTO): Observable<any> {
    return this.http.delete<EventDTO>(this.eventUrl + '/' + eventDTO.id);
  }
}
