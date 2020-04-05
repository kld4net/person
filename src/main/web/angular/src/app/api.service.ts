import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from './person';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiUrl = '/api/persons/'
  constructor(private http : HttpClient){}

  
  addPerson (person : Person): Observable<Person> {
    return this.http.post<Person>(this.apiUrl, person);
  }


  getPerson(id: number): Observable<Person> {
    const url = this.apiUrl+"/" + id;
    return this.http.get<Person>(url);
  }

  updatePerson (id, person): Observable<any> {
    const url = this.apiUrl+"/" + id;
    return this.http.put(url, person);
  }

  
  getPersons (): Observable<Person[]> {
    return this.http.get<Person[]>(this.apiUrl);
  }



  deletePerson (id): Observable<Person> {
    const url = this.apiUrl+"/" + id;
    return this.http.delete<Person>(url);
  }

}
