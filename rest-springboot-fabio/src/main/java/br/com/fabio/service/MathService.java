package br.com.fabio.service;


import org.springframework.stereotype.Service;

import br.com.fabio.conveter.NumberConverter;

@Service
public class MathService {
	
	
	public Double sum(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
	}
	
	public Double multiplication(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
	}
	
	public Double division(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
	}
	
	public Double decrease(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
	}
	
	public boolean isNumeric(String numberOne, String numberTwo) {
		return NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo);
	}
	

}
