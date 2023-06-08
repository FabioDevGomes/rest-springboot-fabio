package br.com.fabio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.dto.vo.PersonDto;
import br.com.fabio.dto.vo.v2.PersonDtoV2;
import br.com.fabio.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Endpoints for manager people")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Find a person - sumary", description = "Find a person - description", responses = {
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PersonDto.class)),
					@Content(mediaType = "application/xml", schema = @Schema(implementation = PersonDto.class))
				}
			),
			@ApiResponse(responseCode = "400", content = @Content),
			@ApiResponse(responseCode = "401", content = @Content),
			@ApiResponse(responseCode = "404", content = @Content),
			@ApiResponse(responseCode = "500", content = @Content)
		}
	)
	public PersonDto findById(@PathVariable(value = "id") Long id) {
		return personService.findById(id);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<PersonDto> listAll() {
		return personService.listAll();
	}

	@PostMapping(
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDto create(@RequestBody PersonDto person) {
		return personService.create(person);
	}

	@PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDtoV2 createV2(@RequestBody PersonDtoV2 person) {
		return personService.createV2(person);
	}
	
	@PutMapping(
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDto update(@RequestBody PersonDto person) throws Exception {
		return personService.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
