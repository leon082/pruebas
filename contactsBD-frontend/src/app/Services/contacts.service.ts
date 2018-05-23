import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Contact } from '../model/contact';
import { State } from '../model/state';

// Header
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class ContactsService {

  // DEV
  private OPERACION_API = '/contactsBD-ws/contacts/';
  constructor(private http: HttpClient) { }

  getAllContacts() {
    return this.http.get<Contact[]>(this.OPERACION_API, httpOptions)
  }

  getallStates() {
    return this.http.get<State[]>(this.OPERACION_API + 'getAllEstates', httpOptions)

  }

  saveContact(contact: Contact) {
    return this.http.post<String>(this.OPERACION_API + 'saveContact', contact, httpOptions)
  }

  deleteContact(id: number) {
    return this.http.delete<String>(this.OPERACION_API + 'deleteContact/' + id, httpOptions)
  }
  updateContact(contact: Contact) {
    return this.http.put<Contact>(this.OPERACION_API + 'updateContact/', contact, httpOptions)
  }


}
