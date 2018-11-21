import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Location} from '@angular/common';
import {CreateRoomForm, Room} from '../room-list/models/room';
import {RoomService} from '../room-list/service/room.service';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-room-update',
  templateUrl: './room-update.component.html',
  styleUrls: ['./room-update.component.css']
})

export class RoomUpdateComponent implements OnInit {

  @Input() room: Room;

  public roomForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private roomService: RoomService) {
  }

  ngOnInit() {
    console.log(`Welcome to update !` + this.room.name);
    this.initAuctionCreateForm(this.room);
    this.roomForm.patchValue(this.room);
  }

  private initAuctionCreateForm(room: Room): void {
    const createAuctionForm = new CreateRoomForm(room, this.fb);
    this.roomForm = this.fb.group(createAuctionForm);
  }

  onUpdateRoom() {
    let id = this.room.id;
    console.warn(this.roomForm.value);
    this.room = this.roomForm.value;
    this.room.id = id;
    this.roomService.updateRoom(this.room).subscribe(room => {
      this.room = room;
      console.log('Reservation successfully updated');
    });
    console.log(`room with the id ` + this.room.id + ` successfully update!`);
    this.initAuctionCreateForm(this.room);
    this.router.navigate(['/roomlist']);
  }


}
