import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {CustomerComponent} from './customer/customer.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {ContactComponent} from "./contact/contact.component";
import {HomeComponent} from "./home/home.component";
import {DetailsCustomerComponent} from "./customer/details-customer.component";
import {CreateRoomComponent} from "./hotel-management/room-create/room-create.component";
import {AuthGuard} from "./auth/auth.guard";

const routes: Routes = [
  {
    path: 'customers',
    component: CustomerComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'add',
    component: AddCustomerComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'customerDetails/:id',
    component: DetailsCustomerComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'createRoom',
    component: CreateRoomComponent,
    canActivate: [AuthGuard]
  },

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

