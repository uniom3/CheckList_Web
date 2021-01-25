package com.mendonca.checkilist.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mendonca.checklist.entities.Colaborador;



public class ColaboradorValidator implements Validator {

		
	@Override
	public boolean supports(Class<?> clazz) {
				
		return Colaborador.class.equals(clazz);
	}
	@Override
	public void validate(Object object, Errors errors) {
	/*	
      Colaborador f = (Colaborador) object;
		
		LocalDate entrada = f.getDataEntrada();
		
		if (f.getDataSaida() != null) {
			if (f.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.Colaborador.dataSaida");
			}
		}*/
	}

}
