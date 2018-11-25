import {Component, OnInit} from '@angular/core';
import {Room, SearchRoomForm} from './models/room';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomService} from './service/room.service';
import {TokenStorageService} from '../../auth/token-storage.service';
import {FormBuilder, FormGroup} from "@angular/forms";

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
  searchRoomForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomService: RoomService,
              private fb: FormBuilder,
              private token: TokenStorageService) {
  }

  ngOnInit() {
    this.isLoggedIn = this.token.isLoggedIn.subscribe(isLoggedIn => {
      this.isLoggedIn = isLoggedIn;
    });
    this.isLoggedIn = this.token.getToken() !== undefined;
    this.loodRooms();
    this.showSearch = true;
    this.searchRoomForm = this.fb.group(new SearchRoomForm(this.fb));
  }

  loodRooms() {
    this.roomService.getRooms().subscribe((data: Room[]) => {
      // this.availableRooms = data;
      // this.cachedRooms = this.availableRooms;
    });
  }

  search() {
    this.roomService.searchRooms(this.searchRoomForm.value).subscribe((data: Room[]) => {
      this.availableRooms = data;
    });
  }

  resetSearch() {
    this.searchRoomForm.reset();
  }

  searchAdmin() {
    if (this.searchRoom) {
      this.availableRooms = this.availableRooms.filter(
        item => item.name === this.searchRoom.name || item.capacity === this.searchRoom.capacity ||
          item.pricePerNight === this.searchRoom.pricePerNight);
    }
  }

  resetAdminSearch() {
    this.availableRooms = this.cachedRooms;
    if (this.searchRoom.name) {
      this.searchRoom.name = null;
    }
    if (this.searchRoom.capacity) {
      this.searchRoom.capacity = null;
    }
    if (this.searchRoom.pricePerNight) {
      this.searchRoom.pricePerNight = null;
    }
  }
}
