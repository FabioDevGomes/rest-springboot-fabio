package br.com.fabio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.exceptions.UnsuporteMathOperationExceptions;
import br.com.fabio.service.MathService;

@RestController
public class MathController {
	
	@Autowired
	MathService mathService;

	@GetMapping(value = "sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!mathService.isNumeric(numberOne, numberTwo)) {
			throw new UnsuporteMathOperationExceptions("please set a numeric value");
		}
		
		return mathService.sum(numberOne, numberTwo);
	}
	
	@GetMapping(value = "mul/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!mathService.isNumeric(numberOne, numberTwo)) {
			throw new UnsuporteMathOperationExceptions("please set a numeric value");
		}
		
		return mathService.multiplication(numberOne, numberTwo);
	}
	
	@GetMapping(value = "div/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!mathService.isNumeric(numberOne, numberTwo)) {
			throw new UnsuporteMathOperationExceptions("please set a numeric value");
		}
		
		return mathService.division(numberOne, numberTwo);
	}
	
	@GetMapping(value = "dec/{numberOne}/{numberTwo}")
	public Double decrease(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!mathService.isNumeric(numberOne, numberTwo)) {
			throw new UnsuporteMathOperationExceptions("please set a numeric value");
		}
		
		return mathService.decrease(numberOne, numberTwo);
	}
	
}
