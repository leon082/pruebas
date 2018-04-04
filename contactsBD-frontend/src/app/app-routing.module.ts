// Modules
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//component
import { ContactsComponent } from './contacts/contacts.component';

const routes: Routes = [

    { path: 'contacts', component: ContactsComponent },
    { path: '', pathMatch:'full', redirectTo:'contacts'},
    { path: '**', pathMatch:'full', redirectTo:'contacts'}


];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
