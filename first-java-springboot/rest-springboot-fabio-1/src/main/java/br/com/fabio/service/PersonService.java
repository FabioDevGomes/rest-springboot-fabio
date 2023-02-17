package br.com.fabio.service;

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

}
