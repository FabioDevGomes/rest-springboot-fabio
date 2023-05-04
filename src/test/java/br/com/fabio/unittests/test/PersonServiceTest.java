package br.com.fabio.unittests.test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.fabio.dto.vo.PersonDto;
import br.com.fabio.dto.vo.v2.PersonDtoV2;
import br.com.fabio.exceptions.RequiredObjectIsNullFoundException;
import br.com.fabio.mapper.PersonMapper;
import br.com.fabio.model.Person;
import br.com.fabio.repository.PersonRepository;
import br.com.fabio.service.PersonService;
import br.com.fabio.unittests.mapper.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PersonServiceTest {
	
	MockPerson mockPerson;
	
	@InjectMocks
	private PersonService service;

	@Mock
	private PersonRepository repository;

	@Mock
	private PersonMapper mapper;

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

	//@Test
	void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		Person entity = mockPerson.mockEntityWhitoutId();
		Person peristed = mockPerson.mockEntity();
		
		PersonDto dto = mockPerson.mockDto(1);
		
		when(repository.save(Mockito.any(Person.class))).thenReturn(peristed);
		
		PersonDto result = service.create(dto);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		
		assertEquals("Person 1", result.getFirstName());
		assertEquals("Alves 1", result.getLastName());
		assertEquals("Eddress person 1", result.getAddress());
		assertEquals("Male", result.getGander());
	}

	@Test
	void testCreateV2() {
		Person entity = mockPerson.mockEntity();
		Person peristed = entity;
		peristed.setId(1L);
		
		PersonDtoV2 dto = mockPerson.mockDtoV2(1);
		
		when(repository.save(entity)).thenReturn(peristed);
		when(mapper.convertDtoToEntity(dto)).thenReturn(entity);
		when(mapper.convertEntityToDto(entity)).thenReturn(dto);
		
		PersonDtoV2 result = service.createV2(dto);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		
		assertEquals("Person 1", result.getFirstName());
		assertEquals("Alves 1", result.getLastName());
		assertEquals("Eddress person 1", result.getAddress());
		assertEquals("Male", result.getGander());	
	}
	
	@Test
	void testUpdate() throws Exception {
		Person peristed = mockPerson.mockEntity();
		PersonDto dto = mockPerson.mockDto(1);
		dto.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(peristed));
		when(repository.save(Mockito.any(Person.class))).thenReturn(peristed);

		PersonDto result = service.update(dto);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		
		assertEquals("Person 1", result.getFirstName());
		assertEquals("Alves 1", result.getLastName());
		assertEquals("Eddress person 1", result.getAddress());
		assertEquals("Male", result.getGander());	
	}
	
	@Test
	void testUpdateIsNullException() throws Exception {
		assertThatThrownBy(() -> { 
			service.update(null); }, "Test explosive code")
		             .isInstanceOf(RequiredObjectIsNullFoundException.class)
		             .hasMessageContaining("It is not allowed to persist a null object!");
	}

	@Test
	void testDelete() {
		Person peristed = mockPerson.mockEntity();
		PersonDto dto = mockPerson.mockDto(1);
		dto.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(peristed));

	}
}
