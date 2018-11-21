import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ContactComponent} from './contact/contact.component';
import {HomeComponent} from './home/home.component';
import {CreateRoomComponent} from './hotel-management/room-create/room-create.component';
import {AuthGuard} from './auth/auth.guard';
import {CustomerListComponent} from './hotel-management/customer-list/customer-list.component';
import {CustomerAddComponent} from './hotel-management/customer-add/customer-add.component';
import {CustomerDetailComponent} from './hotel-management/customer-detail/customer-detail.component';

const routes: Routes = [
  {
    path: 'customers',
    component: CustomerListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'add',
    component: CustomerAddComponent,
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
    component: CustomerDetailComponent,
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

