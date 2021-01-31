package com.mendonca.web.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.services.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, Optional<Cargo>> {

	@Autowired
	private CargoService service;
	
	@Override
	public Optional<Cargo> convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}
}
