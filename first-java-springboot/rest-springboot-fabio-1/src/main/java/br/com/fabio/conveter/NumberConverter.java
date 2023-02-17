package br.com.fabio.conveter;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class NumberConverter {
	
	public static Double convertToDouble(String strNumber) {
		if(Objects.isNull(strNumber)) {
			return 0D;
		}
		
		String number = strNumber.replace(",", ".");
		if(isNumeric(strNumber)) {
			return Double.parseDouble(strNumber);
		}
		return 0D;
	}
	
	public static boolean isNumeric(String strNumber) {
		if(Objects.isNull(strNumber)) {
			return false;
		}
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
