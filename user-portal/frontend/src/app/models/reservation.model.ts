import {Room} from '../hotel-management/room-list/models/room';
import {Customer} from './customer.model';

export class Reservation {

  id: string;
  room: Room;
  customers: Customer[];
  rabatt: string;
  duration: number;
  beginnDate: Date;
  endDate: Date;
}
