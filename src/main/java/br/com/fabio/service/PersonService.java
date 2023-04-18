package br.com.fabio.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import br.com.fabio.controller.PersonController;
import br.com.fabio.dto.vo.PersonDto;
import br.com.fabio.dto.vo.v2.PersonDtoV2;
import br.com.fabio.exceptions.ResourceNotFoundException;
import br.com.fabio.mapper.DozerMapper;
import br.com.fabio.mapper.PersonMapper;
import br.com.fabio.model.Person;
import br.com.fabio.repository.PersonRepository;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonMapper mapper;
	
	public PersonDto findById(Long id){
		logger.info("find one person");

		return find(id);
	}
	
	public List<PersonDto> listAll(){
		logger.info("list person");
		return DozerMapper.parseListObjects(personRepository.findAll(), PersonDto.class);
	}
	
	public PersonDto create(PersonDto person) {
		logger.info("create one person");
		
		Person personEntity = null;
		PersonDto personDto = null;
		try {
			Person d = DozerMapper.parseObject(person, Person.class);
			personEntity = personRepository.save(d);
			personDto = DozerMapper.parseObject(personEntity, PersonDto.class);
		} catch (Exception e) {
			logger.severe("error parse");
			e.printStackTrace();
		}
		return personDto;
	}

	public PersonDtoV2 createV2(PersonDtoV2 person) {
		logger.info("create one person v2");
		
		Person personEntity = personRepository.save(mapper.convertDtoToEntity(person));
		return mapper.convertEntityToDto(personEntity);
	}
	
	public PersonDto update(PersonDto person) throws Exception {
		logger.info("update one person");
		
		var entity = find(person.getKey());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGander(person.getGander());
		
		Person personEntity = personRepository.save(DozerMapper.parseObject(entity, Person.class));
		return DozerMapper.parseObject(personEntity, PersonDto.class);
	} 

	private PersonDto find(Long id) {
		Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		PersonDto vo = DozerMapper.parseObject(entity, PersonDto.class);
		try {
			vo.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonController.class).findById(id)).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;

	}
	
	public void delete(Long id) throws Exception {
		logger.info("delete one person");
		PersonDto entity = find(id);
		personRepository.delete(DozerMapper.parseObject(entity, Person.class));
	}

}
