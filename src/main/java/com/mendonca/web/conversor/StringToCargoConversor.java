package com.mendonca.web.conversor;

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
			System.out.print("if");
			return null;
		}
		System.out.print("entrada do metodo");
		Integer id = Integer.valueOf(text);
		System.out.print("meio do metodo");
		return service.findById(id);
	}
}
