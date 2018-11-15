import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Customer } from '../models/customer.model';
import {Observable} from "rxjs/index";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CustomerService {

  constructor(private http: HttpClient) {}

  private customerUrl = 'http://localhost:8282/customers';
  //private customerUrl = '/api';

  public getCustomers() {
    return this.http.get<Customer[]>(this.customerUrl);
  }

  public deleteCustomer(customer): Observable<any>  {
    return this.http.delete(this.customerUrl + '/' + customer.id);
  }

  public createCustomer(customer): Observable<any>  {
    return this.http.post<Customer>(this.customerUrl, customer);
  }

  public getCustomer(customer): Observable<any>   {
    return this.http.get<Customer>(this.customerUrl + '/' + customer.id);
  }

  public getCustomerWithId(id): Observable<any> {
    const url = this.customerUrl + '/' + id;
    return this.http.get(url);
  }

  public updateCustomer(customer): Observable<any> {
    return this.http.put<Customer>(this.customerUrl + '/' + customer.id , customer);
  }
}
