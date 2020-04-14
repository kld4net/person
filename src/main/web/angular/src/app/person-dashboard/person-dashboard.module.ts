import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PersonListComponent } from '.././person-list/person-list.component';
import { AddPersonComponent } from '.././add-person/add-person.component';
import { EditPersonComponent } from '.././edit-person/edit-person.component';

import {ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from '.././app-routing.module';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    PersonListComponent,
    AddPersonComponent,
    EditPersonComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule
  ]
})
export class PersonDashboardModule { }
