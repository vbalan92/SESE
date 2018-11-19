import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Location} from '@angular/common';
import {Room} from '../room-list/models/room';
import {ROOMS} from '../room-list/models/mock-room';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {RoomService} from '../room-list/service/room.service';

@Component({
  selector: 'app-room-detail',
  templateUrl: './room-detail.component.html',
  styleUrls: ['./room-detail.component.css']
})
export class RoomDetailComponent implements OnInit {

  room: Room;
  showUpdate: boolean;

  constructor(private route: ActivatedRoute,
              private roomService: RoomService) {
  }

  ngOnInit() {
    let roomId = +this.route.snapshot.paramMap.get('id');
    this.roomService.getRoomWithId(roomId).subscribe(data => {
      this.room = data;
      console.log('Room with id' + roomId + 'founded');
    });
    /**
     if (this.room === null || this.room === 'undefined') {
      this.room = ROOMS.find(room => room.id === roomId);
    }
     **/
    console.log(`Room details of the room with the id ` + roomId + ` requested!`);
  }

  deleteRoom(roomToDelete: Room) {
    console.log('Room to delete' + roomToDelete.name);
    this.roomService.deleteRoom(roomToDelete).subscribe(data => {
      this.room = data;
      console.log('Room has been deleted');
    }, error => console.error('error by delete room ' + roomToDelete.name));
  }

  updateRoom(room: Room) {
    console.log('called update room ' + room.name);
    this.showUpdate = !this.showUpdate;
  }
}
