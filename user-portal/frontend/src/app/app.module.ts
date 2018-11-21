import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app.routing.module';
import {CustomerService} from './services/customer.service';
import {HttpClientModule} from '@angular/common/http';
import {UiModule} from './ui/ui.module';
import {ContactComponent} from './contact/contact.component';
import {HotelManagementModule} from './hotel-management/hotel-management.module';
import {HomeComponent} from './home/home.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ReservationService} from './services/reservation.service';
import {RoomService} from './hotel-management/room-list/service/room.service';
import {httpInterceptorProviders} from './auth/auth-interceptor';
import {ContactService} from './services/contact.service';

@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    UiModule,
    HotelManagementModule,
    NgbModule.forRoot()
  ],
  providers: [CustomerService, ReservationService, RoomService, ContactService, httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
