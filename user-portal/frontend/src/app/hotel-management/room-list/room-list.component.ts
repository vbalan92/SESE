import {Component, OnInit} from '@angular/core';
import {Room} from "./models/room";
import {ROOMS} from "./models/mock-room";
import {ActivatedRoute, Router} from "@angular/router";
import {RoomService} from "./service/room.service";

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  availableRooms: Room[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomService: RoomService) {
  }

  ngOnInit() {
    this.createRooms();
  }

  createRooms() {

    console.log(ROOMS[0]);
    let room: Room = new Room();
    room.name = ROOMS[0].name;
    room.capacity = ROOMS[0].capacity;
    room.description = ROOMS[0].description;
    room.price = ROOMS[0].price;
    room.mainPicture = ROOMS[0].mainPicture;
    room.type = ROOMS[0].type;
    this.roomService.createRoom(room).subscribe(
      data => {
        console.log(' room has been created ' + ROOMS[0].id);
      },
      error => console.error('error'),
      () => this.roomService.getRooms().subscribe(data => {
        this.availableRooms = data;
      })
    );
  }
}
