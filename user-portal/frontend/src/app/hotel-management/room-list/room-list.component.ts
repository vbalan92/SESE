import {Component, OnInit} from '@angular/core';
import {Room} from './models/room';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomService} from './service/room.service';
import {TokenStorageService} from '../../auth/token-storage.service';

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
    this.isLoggedIn = this.token.isLoggedIn.subscribe(isLoggedIn => {
      this.isLoggedIn = isLoggedIn;
    });
    this.isLoggedIn = this.token.getToken() !== undefined;
    this.loodRooms();
    this.showSearch = true;
  }

  loodRooms() {
    this.roomService.getRooms().subscribe((data: Room[])  => {
      this.availableRooms =  data;
      this.cachedRooms = this.availableRooms;
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
