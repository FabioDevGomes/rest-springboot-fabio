package br.com.fabio.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.fabio.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		logger.info("find one person");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Fábio");
		person.setLastName("Alves");
		person.setAddress("rua bahia");
		
		return person;
	}
	
	public List<Person> listAll(){
		logger.info("list person");
		List<Person> person = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			person.add(personMock(i));
			
		}
		return person;
	}
	
	public Person create(Person person) {
		logger.info("create one person");
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("update one person");
		
		return person;
	}
	
	public void delete(String id) {
		logger.info("delete one person");
	}

	private Person personMock(int count) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Fábio " + count);
		person.setLastName("Alves");
		person.setAddress("rua bahia");
		
		return person;
	}

}
