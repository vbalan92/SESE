import {Component, OnInit} from '@angular/core';
import {Room} from './models/room';
import {ROOMS} from './models/mock-room';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomService} from './service/room.service';
import {TokenStorageService} from '../../auth/token-storage.service';
import {Room} from './models/room';
import {ROOMS} from './models/mock-room';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomService} from './service/room.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  availableRooms: Room[];
  isLoggedIn: boolean;
  cachedRooms: Room[];
  searchRoom: Room = new Room();
  showSearch: boolean;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomService: RoomService,
              private token: TokenStorageService) {
  }

  ngOnInit() {
    this.createRooms();
    this.isLoggedIn = this.token.getAuthorities().length > 0;
    this.loodRooms();
    this.showSearch = true;
  }

  loodRooms() {
    this.roomService.getRooms().subscribe(data => {
      this.availableRooms = data;
      this.cachedRooms = this.availableRooms;
    });

    console.log(ROOMS[0]);
    let room: Room = new Room();
    room.name = ROOMS[0].name;
    room.capacity = ROOMS[0].capacity;
    room.description = ROOMS[0].description;
    room.price = ROOMS[0].price;
    room.mainPicture = ROOMS[0].mainPicture;
    room.type = ROOMS[0].type;
    this.roomService.getRooms().subscribe(data => {
      this.availableRooms = data;
    });
  }
  search() {
    if (this.searchRoom) {
      this.availableRooms = this.availableRooms.filter(
        item => item.name === this.searchRoom.name || item.capacity === this.searchRoom.capacity || item.price === this.searchRoom.price);
    }
  }

  resetSearch() {
    this.availableRooms = this.cachedRooms;
  }
}
