import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {Observable} from 'rxjs/index';
import {Room, SearchRoom} from '../models/room';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class RoomService {

  constructor(private http: HttpClient) {}

  private roomUrl = './api/rooms';

  public getRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(this.roomUrl);
  }

  public deleteRoom(room): Observable<any>  {
    return this.http.delete(this.roomUrl + '/' + room.id);
  }

  public createRoom(room): Observable<any>  {
    return this.http.post<Room>(this.roomUrl, room);
  }

  public getRoom(room): Observable<any>   {
    return this.http.get<Room>(this.roomUrl + '/' + room.id);
  }

  public getRoomWithId(id): Observable<any> {
    const url = this.roomUrl + '/' + id;
    return this.http.get(url);
  }

  public updateRoom(room): Observable<any> {
    return this.http.put<Room>(this.roomUrl + '/' + room.id , room);
  }

  searchRooms(searchRoom: SearchRoom): Observable<Room[]> {
    const fromDate = this.getDateInMillis(searchRoom.from);
    const toDate = this.getDateInMillis(searchRoom.to);
    let url;
    if(searchRoom.fromPrice != null && searchRoom.toPrice!= null){
      url = `${this.roomUrl}?from=${fromDate}&to=${toDate}&capacity=${searchRoom.capacity}&fromPrice=${searchRoom.fromPrice}&toPrice=${searchRoom.toPrice}`
    }
    else if(searchRoom.fromPrice != null){
      url = `${this.roomUrl}?from=${fromDate}&to=${toDate}&capacity=${searchRoom.capacity}&fromPrice=${searchRoom.fromPrice}&toPrice=`
    }
    else if(searchRoom.toPrice!= null){
      url = `${this.roomUrl}?from=${fromDate}&to=${toDate}&capacity=${searchRoom.capacity}&fromPrice=&toPrice=${searchRoom.toPrice}`
    }
    else{
      url = `${this.roomUrl}?from=${fromDate}&to=${toDate}&capacity=${searchRoom.capacity}&fromPrice=&toPrice=`
    }

    return this.http.get<Room[]>(url);
  }

  private getDateInMillis(date: any) {
    let date2 = new Date(Date.UTC(date.year, date.month - 1, date.day));
    return date2.getTime();
  }
  }
