import { Component, OnInit, ViewChild } from '@angular/core';
import { ContactsService } from '../Services/contacts.service';
import { tap } from 'rxjs/operators';
import { MatTableDataSource, MatDialog, MatIconModule } from '@angular/material';
import { Contact } from '../model/contact';
import { State } from '../model/state';
import { FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {

  // Table elements
  ELEMENT_DATA: Contact[] = [];
  displayedColumns = ['id', 'nombre', 'apellido', 'telefono', 'email', 'estado','acciones'];
  dataSource: MatTableDataSource<Contact>;

  // Search object
  contact: Contact;
  // Pagination
  currentPage: number;
  length: number;
  pageSize: number;
  // Flags
  search: boolean;
  edit: boolean;
  add: boolean;
  

  //resultado
  result:String;



  // Form Validator
  fcEmail: FormControl;
  fcEstado: FormControl;
  states: State[]=[];
  

  constructor(private contactsService: ContactsService, public plantillaDialog: MatDialog) { }

  ngOnInit() {
    this.fcEmail = new FormControl('', [Validators.email]);
    this.fcEstado = new FormControl('', [Validators.required]);
    this.contact = new Contact();
    
    this.result="";
    //this.contacEstado="1";

    this.getAllContacts();
    this.getAllStates();
    
  }

  getAllStates(): void {
    this.contactsService.getallStates().subscribe(
      success => {
        this.states = success;
        
      }, err => {
        console.log("ERROR GETALL ", err);
      }
    );
  }



  getErrorEmail(): string {
    return this.fcEmail.hasError('email') ? 'Tipo de correo no valido' : '';
  }


  getAllContacts(): void {
    this.contactsService.getAllContacts().subscribe(
      success => {
        this.ELEMENT_DATA = success;
        this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
      }, err => {
        console.log("ERROR GETALL ", err);
      }
    );
  }
  saveContact(): void {
    if (this.contact.id == 0) {
      this.saveService();
    } else {
      this.editService();
    }
    

  }
  editService(): void {
    this.contactsService.updateContact(this.contact).subscribe(
      success => {
        this.cleanContact();
        this.getAllContacts();
      }, err => {
        if (err.status == 200) {
          this.result="Contacto Editado";
          this.cleanContact();
          this.getAllContacts();
        }
        console.log("ERROR SAVE ", err);
      }
    );
  }

  saveService(): void {
    this.contactsService.saveContact(this.contact).subscribe(
      success => {
        this.result=success;
        this.cleanContact();
        this.getAllContacts();
      }, err => {
        if (err.status == 200) {
          this.result="Contacto Guardado";
          this.cleanContact();
          this.getAllContacts();
        }
        console.log("ERROR SAVE ", err);
      }
    );
  }

  
  deleteContact(row): void {
    this.contactsService.deleteContact(row.id).subscribe(
      success => {
        this.result=success;
        this.cleanContact();
        this.getAllContacts();
      }, err => {
        if (err.status == 200) {
          this.result="Contacto Eliminado";
          this.cleanContact();
          this.getAllContacts();
        }
        console.log("ERROR DELETE ", err);
      }
    );
  }
  loadContact(row): void {

    this.contact.id = row.id;
    this.contact.firstName = row.firstName;
    this.contact.lastName = row.lastName;
    this.contact.phoneNumber = row.phoneNumber;
    this.contact.email = row.email;
    this.contact.estado = row.estado;
    row.flag=true;
  }

  cancelar():void{
    this.cleanContact();
    this.getAllContacts();
  }

 
  isDataEmpty(): boolean {
    return this.ELEMENT_DATA.length == 0;
  }

  isValidForm(): boolean {

    if (
      (this.contact.firstName === null ||
        this.contact.lastName === null ||
        this.contact.phoneNumber === null ||
        this.contact.email === null)
      ||
      (this.contact.firstName === "" ||
        this.contact.lastName === "" ||
        this.contact.phoneNumber === "" ||
        this.contact.email === "")
    ) {
      return false;
    } else {
      return true;
    }



  }
  cleanContact(): void {

    this.contact.id = 0;
    this.contact.firstName = null;
    this.contact.lastName = null;
    this.contact.phoneNumber = null;
    this.contact.email = null;
    this.contact.estado=null;

    this.search = true;
    this.add = false;
    this.edit = false;

    this.fcEmail = new FormControl('', [Validators.email]);
    this.fcEstado = new FormControl('', [Validators.required]);

    
  }

}
