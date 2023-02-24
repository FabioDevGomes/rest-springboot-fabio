package br.com.fabio.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabio.exceptions.ResourceNotFoundException;
import br.com.fabio.model.Person;
import br.com.fabio.repository.PersonRepository;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository personRepository;
	
	public Person findById(Long id) {
		logger.info("find one person");

		return find(id);
	}
	
	public List<Person> listAll(){
		logger.info("list person");
		return personRepository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("create one person");
		
		return personRepository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("update one person");
		
		var entity = find(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGander(person.getGander());
		
		return personRepository.save(entity);
	}

	private Person find(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public void delete(Long id) {
		logger.info("delete one person");
		var entity = find(id);
		personRepository.delete(entity);
	}

}
