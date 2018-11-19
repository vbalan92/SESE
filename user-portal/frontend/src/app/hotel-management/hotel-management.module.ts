import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RoomListComponent} from './room-list/room-list.component';
import {RoomListItemComponent} from './room-list/room-list-item/room-list-item.component';
import {RoomDetailComponent} from './room-detail/room-detail.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerDetailComponent} from './customer-detail/customer-detail.component';
import {RouterModule, Routes} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CreateRoomComponent} from "./room-create/room-create.component";
import {AuthGuard} from "../auth/auth.guard";

const routes: Routes = [
  {
    path: 'management',
    component: RoomListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'roomlist',
    component: RoomListComponent
  },
  {
    path: 'roomdetail',
    component: RoomDetailComponent
  },
  {
    path: 'roomdetail/:id',
    component: RoomDetailComponent
  },
  {
    path: 'customerlist',
    component: CustomerListComponent
  },
  {
    path: 'customerdetail',
    component: CustomerDetailComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'customerdetail/:id',
    component: CustomerDetailComponent,
    canActivate: [AuthGuard]
  },
];

export const managementRouting = RouterModule.forChild(routes);

@NgModule({
  declarations: [
    RoomListComponent,
    RoomListItemComponent,
    RoomDetailComponent,
    CustomerListComponent,
    CustomerDetailComponent,
    CreateRoomComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
    managementRouting
  ]
})
export class HotelManagementModule {
}
