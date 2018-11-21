import {FormBuilder, FormControl, Validators} from '@angular/forms';

export enum RoomType {
  EZ = 'EZ',
  DZ = 'DZ',
  VIP = 'VIP'
}

export class Room {
  id: number;
  name: string;
  type: RoomType;
  description: string;
  mainPicture: string;
  capacity: number;
  pricePerNight: number;
  /**
  createdAt: string;
  createdFrom: string;
   **/
}

export class CreateRoomForm {
  name: FormControl;
  type: FormControl;
  pricePerNight: FormControl;
  capacity: FormControl;
  description: FormControl;
  mainPicture: FormControl;

  constructor(private auction: Room, private fb: FormBuilder) {
    this.name = this.fb.control(this.auction.name, Validators.required);
    this.type = this.fb.control(this.auction.type, Validators.required);
    this.pricePerNight = this.fb.control(this.auction.pricePerNight, Validators.required);
    this.capacity = this.fb.control(this.auction.capacity, Validators.required);
    this.mainPicture = this.fb.control(this.auction.mainPicture);
    this.description = this.fb.control(this.auction.description, Validators.required);
    //this.createdAt = this.fb.control(this.auction.createdAt); // todo maybe validate
    //this.createFrom = this.fb.control(this.auction.createdFrom); // todo maybe validate
  }
}
