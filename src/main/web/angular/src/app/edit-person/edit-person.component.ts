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
      personFirstName: ['',[Validators.required, Validators.pattern("^[أ-يa-zA-Z]+$")]],
      personSecondName: ['',[Validators.pattern("^[أ-يa-zA-Z]*$")]],
      personThirdName: ['',[Validators.pattern("^[أ-يa-zA-Z]*$")]],
      personFamilyName: ['',[Validators.required, Validators.pattern("^[أ-يa-zA-Z]+$")]],
      personSex: ['0', [Validators.required]],
      personStatus: ['0'],
      personBirthdate: [''],
      personIdType: ['0', [Validators.required]],
      personIdNo: ['', Validators.pattern("^[0-9]{10}")],
      personEmail: ['',[Validators.email]],
      personMobile: ['',Validators.pattern("^[0-9]{10}?[0-9]*")],
      personAddress: ['']
    });
  }




  get personFirstName() {
    return this.personForm.get('personFirstName');
 }


 get personSecondName() {
  return this.personForm.get('personSecondName');
}


get personThirdName() {
  return this.personForm.get('personThirdName');
}

get personFamilyName() {
  return this.personForm.get('personFamilyName');
}

get personEmail() {
  return this.personForm.get('personEmail');
}

get personIdNo() {
  return this.personForm.get('personIdNo');
}

get personMobile() {
  return this.personForm.get('personMobile');
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
