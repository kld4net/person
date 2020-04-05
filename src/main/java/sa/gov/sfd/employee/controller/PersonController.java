package sa.gov.sfd.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sa.gov.sfd.employee.domain.person.PersonService;
import sa.gov.sfd.employee.model.PersonModel;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/")
	public void addPerson(@RequestBody PersonModel person) {
	  personService.insert(person);
	}

	@GetMapping("/")
	public List<PersonModel> getAll() {
		
		return personService.finalAll();
	}

	@GetMapping("/{id}")
	public PersonModel getPerson(@PathVariable("id") Integer id)  {
		return personService.findByUsernid(id);
	}

	@PutMapping("/{id}")
	public PersonModel upatePerson(@PathVariable("id") Integer id , @RequestBody PersonModel person) {
		return personService.update(id, person);
	}

	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable("id") Integer id ) {
		System.out.println("yes");
		personService.remove(id);
	}
}
