import {Component, OnInit} from '@angular/core';
import {ContactService} from '../services/contact.service';
import {Router} from '@angular/router';
import {Contact} from '../models/contact.model';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  public contact: Contact = new Contact();
  public isContactSend: boolean;

  constructor(private contactService: ContactService, private router: Router) {
  }

  createContact(){
    this.contactService.createContact(this.contact)
      .subscribe(data => {
        this.goToContacts();
        alert('Contact has been created successfully.');
        this.isContactSend = true;
      });
  }
  ngOnInit() {
  }

  private goToContacts() {
   // this.router.navigate(['contact']);
  }
}
