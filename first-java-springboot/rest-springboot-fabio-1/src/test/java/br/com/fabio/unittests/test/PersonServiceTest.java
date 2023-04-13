package br.com.fabio.unittests.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.fabio.dto.vo.PersonDto;
import br.com.fabio.model.Person;
import br.com.fabio.repository.PersonRepository;
import br.com.fabio.service.PersonService;
import br.com.fabio.unittests.mapper.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	
	MockPerson mockPerson;
	
	@InjectMocks
	private PersonService service;

	@Mock
	private PersonRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		mockPerson = new MockPerson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() throws Exception {
		Person person = mockPerson.mockEntity();
		
		when(repository.findById(1L)).thenReturn(Optional.of(person));
		PersonDto result = service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("</person/1>;rel=\"self\""));
		assertEquals(1L, result.getKey());
		assertEquals("Person 1", result.getFirstName());
		assertEquals("Alves 1", result.getLastName());
		assertEquals("Eddress person 1", result.getAddress());
		assertEquals("Male", result.getGander());
	}

	@Test
	void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateV2() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
