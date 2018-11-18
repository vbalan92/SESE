import {Component, OnInit} from '@angular/core';
import {CreateRoomForm, Room} from '../room-list/models/room';
import {RoomService} from '../room-list/service/room.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';


@Component({
  selector: 'app-room-detail',
  templateUrl: './room-create.component.html',
  styleUrls: ['./room-create.component.css']
})
export class CreateRoomComponent implements OnInit {


  rooms: Room[];
  private room: Room;
  private roomForm: FormGroup;

  constructor(private router: Router,
              private fb: FormBuilder,
              private roomService: RoomService) {
  }


  ngOnInit() {
    this.room = new Room();
    this.initAuctionCreateForm(this.room);
  }

  private initAuctionCreateForm(room: Room): void {
    const createAuctionForm = new CreateRoomForm(room, this.fb);
    this.roomForm = this.fb.group(createAuctionForm);
  }

  onCreateRoom() {
    console.warn(this.roomForm.value);
    this.room = this.roomForm.value;
    this.roomService.createRoom(this.room).subscribe(room => {
      this.room = room;
      console.log('Reservation successfully created');
    });
    console.log(`room with the id ` + this.room.id + ` successfully created!`);
    this.initAuctionCreateForm(this.room);
  }

  ngOnDestroy(): void {
  }

}
