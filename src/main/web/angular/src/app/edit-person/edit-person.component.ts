import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from '../api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Person } from '../person';

@Component({
  selector: 'app-edit-person',
  templateUrl: './edit-person.component.html',
  styleUrls: ['./edit-person.component.css']
})
export class EditPersonComponent implements OnInit {

  personForm: FormGroup;
  id:number= null;
 
  constructor(private formBuilder: FormBuilder, private activeAouter: ActivatedRoute, private router: Router, private api: ApiService) { }
 
  ngOnInit() {
     
    this.getDetail(this.activeAouter.snapshot.params['id']);
 
    this.personForm = this.formBuilder.group({
      personFirstName: ['', [Validators.required]],
      personSecondName: ['', [Validators.required]],
      personThirdName: ['', [Validators.required]],
      personFamilyName: ['', [Validators.required]],

      personEmail: ['', [Validators.required]],
      personSex: ['', [Validators.required]],
      personStatus: ['', [Validators.required]],
      personBirthdate: ['', [Validators.required]],
      personIdType: ['', [Validators.required]],
      personIdNo: ['', [Validators.required]],
      personMobile: ['', [Validators.required]],
      personAddress: ['', [Validators.required]]
    });
  }
 
  getDetail(id) {
    this.api.getPerson(id)
      .subscribe((data:Person) => {
        this.id = data.id;
        this.personForm.setValue({
          personFirstName: data.personFirstName,
          personSecondName: data.personSecondName,
          personThirdName: data.personThirdName,
          personFamilyName: data.personFamilyName,
          personSex: data.personSex,
          personStatus: data.personStatus,
          personBirthdate: data.personBirthdate,
          personIdType: data.personIdType,
          personIdNo: data.personIdNo,
          personMobile: data.personMobile,
          personEmail: data.personEmail,
          personAddress: data.personAddress
        });
        console.log(data);
      });
  }

  updatePerson(form) {
    this.api.updatePerson(this.id, form)
      .subscribe(res => {
          this.router.navigate(['/']);
        }, (err) => {
          console.log(err);
        }
      );
     
  }
}
