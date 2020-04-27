package com.mendonca.checklist.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.services.ColaboradorService;

@RestController
@RequestMapping(value="/colaboradores")
public class ColaboradorResource  {

	@Autowired
	private ColaboradorService colaboradorService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<List<Colaborador>> findAll(){
		List<Colaborador> obj = colaboradorService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Colaborador>> find(@PathVariable Integer id) {
		Optional<Colaborador> obj = colaboradorService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value= "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Colaborador>> findByNome(@PathVariable String nome){
		List<Colaborador> obj = colaboradorService.findByNome(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@RequestBody Colaborador obj){
		 obj = colaboradorService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

