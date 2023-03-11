package br.com.fabio.mapper;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.fabio.dto.vo.v2.PersonDtoV2;
import br.com.fabio.model.Person;

@Service
public class PersonMapper {

	public PersonDtoV2 convertEntityToDto(Person person) {
		PersonDtoV2 dto = new PersonDtoV2();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setAddress(person.getAddress());
		dto.setGander(person.getGander());
		dto.setBirthDay(new Date());

		return dto;
	}

	public Person convertDtoToEntity(PersonDtoV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGander(person.getGander());
//		dto.setBirthDay(new Date());
		
		return entity;
	}
	
}
