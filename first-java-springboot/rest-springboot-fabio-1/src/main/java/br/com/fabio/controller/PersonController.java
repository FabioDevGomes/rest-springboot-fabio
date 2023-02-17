package br.com.fabio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.model.Person;
import br.com.fabio.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person sum(@PathVariable(value = "id") String id) throws Exception {
		
		return personService.findById(id);
	}
	
}
