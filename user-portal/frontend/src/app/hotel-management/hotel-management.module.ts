import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RoomListComponent} from './room-list/room-list.component';
import {RoomListItemComponent} from './room-list/room-list-item/room-list-item.component';
import {RoomDetailComponent} from './room-detail/room-detail.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerDetailComponent} from './customer-detail/customer-detail.component';
import {RouterModule, Routes} from '@angular/router';
import {NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CreateRoomComponent} from './room-create/room-create.component';
import {AuthGuard} from '../auth/auth.guard';
import {ReservationListComponent} from './reservation-list/reservation-list.component';
import {ReservationDetailComponent} from './reservation-detail/reservation-detail.component';
import {ReservationListItemComponent} from './reservation-list/reservation-list-item/reservation-list-item.component';
import {RoomUpdateComponent} from './room-update/room-update.component';
import {CustomerAddComponent} from './customer-add/customer-add.component';
import {HolidayComponent} from './holiday-management/holiday-component';
import {CalendarModule, DateAdapter} from 'angular-calendar';
import {adapterFactory} from 'angular-calendar/date-adapters/date-fns';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

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
  {
    path: 'reservations',
    component: ReservationListComponent,
    canActivate: [AuthGuard]
  },
];

export const managementRouting = RouterModule.forChild(routes);

@NgModule({
  declarations: [
    RoomListComponent,
    RoomListItemComponent,
    RoomDetailComponent,
    RoomUpdateComponent,
    CustomerListComponent,
    CustomerDetailComponent,
    CustomerAddComponent,
    CreateRoomComponent,
    ReservationListComponent,
    ReservationDetailComponent,
    ReservationListItemComponent,
    HolidayComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
    managementRouting,
    CommonModule,
    FormsModule,
    NgbModalModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    })
  ]
})
export class HotelManagementModule {
}
