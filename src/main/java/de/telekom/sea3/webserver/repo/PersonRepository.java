package de.telekom.sea3.webserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;


// Implementation der Klasse macht Spring automatisch
@Repository 
public interface PersonRepository extends CrudRepository<Person,Long>{

}
