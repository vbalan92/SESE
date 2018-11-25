import {Address} from './address.model';
import {Room} from "../hotel-management/room-list/models/room";
import {Reservation} from "./reservation.model";

export class Customer {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  fax: string;
  webadresse: string;
  rabatt: string;
  birtdate: string;
  notiz: string;
  firmenname: string;
  billAddress: Address = new Address();
  room: Room;
  reservations: Reservation[];


  get _billAddress(): Address {
    return this.billAddress;
  }

  set _billAddress(value: Address) {
    this.billAddress = value;
  }
}
