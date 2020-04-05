import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Person } from '../person';
@Component({
  selector: 'app-add-person',
  templateUrl: './add-person.component.html',
  styleUrls: ['./add-person.component.css']
})
export class AddPersonComponent implements OnInit {

  personForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private api: ApiService) {}
 
 
  ngOnInit() {
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

  addPerson() {
    let person : Person = new Person(null,
      this.personForm.get('personFirstName').value,
      this.personForm.get('personSecondName').value,
      this.personForm.get('personThirdName').value,
      this.personForm.get('personFamilyName').value,
      this.personForm.get('personSex').value,
    this.personForm.get('personStatus').value,
    this.personForm.get('personBirthdate').value,
    this.personForm.get('personIdType').value,
    this.personForm.get('personIdNo').value,
    this.personForm.get('personEmail').value,
    this.personForm.get('personMobile').value,
    this.personForm.get('personAddress').value);
    
console.log(person.personEmail);


    this.api.addPerson(person).subscribe( (res:Person) => { 
      this.router.navigate(['/person']);
      
        }, (err) => {
          console.log(err);
        });
  }

}
