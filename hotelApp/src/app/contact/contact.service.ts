
import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Contact } from '../models/contact.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ContactService {

  constructor(private http: HttpClient) {}

  private contactURL = 'http://localhost:8080/contacts';
  //private contactURL = '/api';

  public getContacts() {
    return this.http.get<Contact[]>(this.contactURL);
  }

  public deleteContact(contact) {
    return this.http.delete(this.contactURL + '/' + contact.id);
  }

  public createContact(contact) {
    return this.http.post<Contact>(this.contactURL, contact);
  }

  public getContact(contact) {
    return this.http.get<Contact>(this.contactURL + '/' + contact.id);
  }

  public updateContact(contact) {
    return this.http.put<Contact>(this.contactURL + '/' + contact.id , contact);
  }
}
