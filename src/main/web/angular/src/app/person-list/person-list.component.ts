import { Component, OnInit } from '@angular/core';
import { Person } from '../person';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  data: Person[] = [];
  constructor(private api: ApiService) { }

  ngOnInit() {
    this.api.getPersons().subscribe(res => {
      this.data = res;
      console.log(res[0].personAddress);
    }, err => {
      console.log(err);
    });
  }

   
  deletePerson(id, index) {
    this.api.deletePerson(id)
      .subscribe(res => {    
          this.data.splice(index,1);
        }, (err) => {
          console.log(err);
        }
      );
  }

}
