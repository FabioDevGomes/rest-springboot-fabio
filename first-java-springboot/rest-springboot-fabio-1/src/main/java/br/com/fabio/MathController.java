package br.com.fabio;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.exceptions.UnsuporteMathOperationExceptions;

@RestController
public class MathController {

	@GetMapping(value = "sum/{numberOne}/{numberTwo}")
	public Double greating(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuporteMathOperationExceptions("please set a numeric value");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(Objects.isNull(strNumber)) {
			return 0D;
		}
		
		String number = strNumber.replace(",", ".");
		if(isNumeric(strNumber)) {
			return Double.parseDouble(strNumber);
		}
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(Objects.isNull(strNumber)) {
			return false;
		}
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
