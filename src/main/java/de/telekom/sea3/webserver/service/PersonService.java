package de.telekom.sea3.webserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import de.telekom.sea3.webserver.model.*;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		System.out.println("PersonService instanziert: " + this.toString());
		System.out.println("PersonRepository: " + personRepository.toString());
		this.personRepository = personRepository;
	}

	public long getSize() {
		return personRepository.count();
	}

	public Personen getAllPersons() {
		Personen personen= new Personen();
		for (Person p: personRepository.findAll()) {
			personen.getPersonen().add(p);
		}
				
		return personen;
	}

	
	public Person get(long id) {
		if (personRepository.findById(id).isPresent()) {
			return  personRepository.findById(id).get();
		}else return null;
	}
	

	public Person add(Person person) {
		personRepository.save(person);
		System.out.println("Person wurde angelegt!");
		return person;
	}

	
	public Person del (long id) {
		personRepository.deleteById(id);
		System.out.println("Person wurde gelöscht!");
		return null;
	}
	
	
	public Person update (Person person) {
		personRepository.save(person);
		System.out.println("Person wurde aktualisiert!");
		return null;
	}
	
	
	public Person delAll() {
		personRepository.deleteAll();
		System.out.println("Alle Personen wurden gelöscht!");
		return null;
	}
	
}
