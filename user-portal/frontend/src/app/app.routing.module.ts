import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {CustomerComponent} from './customer/customer.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {ContactComponent} from "./contact/contact.component";
import {HomeComponent} from "./home/home.component";
import {DetailsCustomerComponent} from "./customer/details-customer.component";
import {CreateRoomComponent} from "./hotel-management/room-create/room-create.component";
import {RoomUpdateComponent} from "./hotel-management/room-update/room-update.component";

const routes: Routes = [
  {path: 'customers', component: CustomerComponent},
  {path: 'add', component: AddCustomerComponent},
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'customerDetails/:id', component: DetailsCustomerComponent},
  {path: 'createRoom', component: CreateRoomComponent},
  {path: 'updateRoom/:id', component: RoomUpdateComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {
}

