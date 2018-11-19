import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {CustomerComponent} from './customer/customer.component';
import {AppRoutingModule} from './app.routing.module';
import {CustomerService} from './customer/customer.service';
import {HttpClientModule} from "@angular/common/http";
import {AddCustomerComponent} from './customer/add-customer.component';
import {UiModule} from './ui/ui.module';
import {ContactComponent} from './contact/contact.component';
import {HotelManagementModule} from './hotel-management/hotel-management.module';
import {HomeComponent} from './home/home.component';
import {DetailsCustomerComponent} from './customer/details-customer.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ReservationService} from './services/reservation.service';
import {RoomService} from './hotel-management/room-list/service/room.service';
import {httpInterceptorProviders} from './auth/auth-interceptor';
import {CreateRoomComponent} from './hotel-management/room-create/room-create.component';
import {RoomUpdateComponent} from "./hotel-management/room-update/room-update.component";

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    AddCustomerComponent,
    ContactComponent,
    HomeComponent, DetailsCustomerComponent
    HomeComponent, DetailsCustomerComponent,
    CreateRoomComponent,
    RoomUpdateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    UiModule,
    HotelManagementModule,
    NgbModule.forRoot()
  ],
  providers: [CustomerService, ReservationService, RoomService, httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
