import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {CustomerComponent} from './customer/customer.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {ContactComponent} from "./contact/contact.component";
import {HomeComponent} from "./home/home.component";
import {DetailsCustomerComponent} from "./customer/details-customer.component";

const routes: Routes = [
  {path: 'customers', component: CustomerComponent},
  {path: 'add', component: AddCustomerComponent},
  {path: 'home', component: HomeComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'customerDetails/:id', component: DetailsCustomerComponent},
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

