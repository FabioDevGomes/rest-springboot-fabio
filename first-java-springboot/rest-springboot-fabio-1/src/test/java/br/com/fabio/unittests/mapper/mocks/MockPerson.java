package br.com.fabio.unittests.mapper.mocks;

import br.com.fabio.dto.vo.PersonDto;
import br.com.fabio.model.Person;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(1);
	}
	
	public PersonDto mockDto() {
		PersonDto pDto = new PersonDto();
		pDto.setFirstName("Person dto");
		
		return pDto;
	}
	
	public Person mockEntity(int number) {
		Person person = new Person();
		person.setId(number);
		person.setFirstName("Person "+ number);
		person.setLastName("Alves "+ number);
		person.setAddress("Eddress person "+ number);
		person.setGander("Male");
		
		return person;
	}
	

}
