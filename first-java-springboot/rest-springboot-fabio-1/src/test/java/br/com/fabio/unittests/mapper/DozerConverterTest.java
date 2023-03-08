package br.com.fabio.unittests.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fabio.mapper.DozerMapper;
import br.com.fabio.model.Person;
import br.com.fabio.unittests.mapper.mocks.MockPerson;


public class DozerConverterTest {
	

	MockPerson mockPerson;
	
	@BeforeEach
	public void setUp() {
		mockPerson = new MockPerson();
	}
	
	@Test
	public void parseTest() {
		Person person = DozerMapper.parseObject(mockPerson.mockDto(), Person.class);
		
		assertEquals(person.getFirstName(), mockPerson.mockDto().getFirstName());
	}

}
