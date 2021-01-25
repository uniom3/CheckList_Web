package com.mendonca.checkilist.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.services.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

	@Autowired
	private CargoService service;
	
	@Override
	public Cargo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return service.buscarPorId(id);
	}
}
