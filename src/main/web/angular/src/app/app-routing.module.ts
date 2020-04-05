import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditPersonComponent } from './edit-person/edit-person.component';
import { PersonListComponent } from './person-list/person-list.component';
import { AddPersonComponent } from './add-person/add-person.component';


const routes: Routes = [
  {
    path: '',
    component: PersonListComponent,
    data: { title: 'List of persons' }
  },
  {
    path: 'person',
    component: PersonListComponent,
    data: { title: 'List of persons' }
  },
  {
    path: 'person/add',
    component: AddPersonComponent,
    data: { title: 'Add person' }
  },
  {
    path: 'person/edit/:id',
    component: EditPersonComponent,
    data: { title: 'Edit person' }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
