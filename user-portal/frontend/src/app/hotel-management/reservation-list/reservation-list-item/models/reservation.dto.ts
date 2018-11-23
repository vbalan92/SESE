import {ReservationDTO} from "../../../room-list/models/reservation";
import {RoomType} from "../../../room-list/models/room";


export class ReservationDetailDTO extends ReservationDTO {

  roomNumber: string;
  roomName: string;
  roomType: RoomType;
  roomMainPicture: string;
}
