import {FormBuilder, FormControl, Validators} from "@angular/forms";

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
  price: number;
}

export class CreateRoomForm {
  name: FormControl;
  type: FormControl;
  price: FormControl;
  capacity: FormControl;
  description: FormControl;
  mainPicture: FormControl;

  constructor(private auction: Room, private fb: FormBuilder) {
    this.name = this.fb.control(this.auction.name, Validators.required);
    this.type = this.fb.control(this.auction.type, Validators.required);
    this.price = this.fb.control(this.auction.price, Validators.required);
    this.capacity = this.fb.control(this.auction.capacity, Validators.required);
    this.mainPicture = this.fb.control(this.auction.mainPicture, Validators.required);
    this.description = this.fb.control(this.auction.description, Validators.required);
  }
