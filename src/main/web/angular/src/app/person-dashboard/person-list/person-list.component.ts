import { Component, OnInit,HostListener } from '@angular/core';
import { Person } from '../../person';
import { ApiService } from '../../api.service';

import { DecimalPipe } from '@angular/common';
import { FormControl } from '@angular/forms';

import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';




@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css'],
  //This is for searching
  providers: [DecimalPipe]

})
export class PersonListComponent implements OnInit {

  test:string='';

  data: Person[] = [];
  originalData: Person[];
  searchText: string = ''; 
  elements: any = []; 

  search(value:any){
    this.data=this.originalData.filter(t => t.personIdNo.includes(value));
    // this.test=value;

  }


  constructor(private api: ApiService) { }

  @HostListener('input') 
  oninput() 
  { 
      this.searchItems(); 
  } 

  searchItems() 
  { 
     if (!this.searchText) {
        //this.mdbTable.setDataSource(this.previous); 
        this.elements = this.data;
     } 
     if (this.searchText) { 
      this.elements= this.data.filter(person => {
              person.personIdNo.includes(this.searchText);
          });
          } 
}

  


  
  ngOnInit() {
    this.api.getPersons().subscribe(res => {
      this.data = res;
      this.originalData = res;
      console.log(res[0].personAddress);
    }, err => {
      console.log(err);
    });
  }

   


  //  search(text: string, pipe: PipeTransform): Person[] {
  //   return this.data.filter(person => {
  //     const term = text.toLowerCase();
  //     return person.personFamilyName.toLowerCase().includes(term)
  //         || person.personIdNo.includes(term);
  //   });
  // }


  
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
