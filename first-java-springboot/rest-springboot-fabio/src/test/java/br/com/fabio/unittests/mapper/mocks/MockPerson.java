package br.com.fabio.unittests.mapper.mocks;

import br.com.fabio.dto.vo.PersonDto;
import br.com.fabio.dto.vo.v2.PersonDtoV2;
import br.com.fabio.model.Person;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(1);
	}

	public Person mockEntityWhitoutId() {
		var mock = mockEntity(1);
		mock.setId(null);
		return mock;
	}
	
	public PersonDto mockDto(int number) {
		var pDto = new PersonDto();
		pDto.setFirstName("Person "+ number);
		pDto.setLastName("Alves "+ number);
		pDto.setAddress("Eddress person "+ number);
		pDto.setGander("Male");
		
		return pDto;
	}

	public PersonDtoV2 mockDtoV2(int number) {
		var pDto = new PersonDtoV2();
		pDto.setFirstName("Person "+ number);
		pDto.setLastName("Alves "+ number);
		pDto.setAddress("Eddress person "+ number);
		pDto.setGander("Male");
		
		return pDto;
	}

	public Person mockEntity(int number) {
		var person = new Person();
		person.setId(Long.valueOf(number));
		person.setFirstName("Person "+ number);
		person.setLastName("Alves "+ number);
		person.setAddress("Eddress person "+ number);
		person.setGander("Male");
		
		return person;
	}
	

}
