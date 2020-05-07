package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.repositories.ColaboradorRepository;
import com.mendonca.checklist.repositories.ColaboradorRepositoryImpl;
import com.mendonca.checklist.services.exceptions.ObjectNotFoundException;


@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ColaboradorRepositoryImpl colaboradorRepositoryImpl;
	

	public Colaborador find(Integer id) {
			
		Optional<Colaborador> obj = colaboradorRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}
	
	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}
	
	public Optional<Colaborador> findById(Integer id) {
		return colaboradorRepository.findById(id);
	}
	
	public Colaborador insert(Colaborador obj) {
		obj.setId(null);
		obj = colaboradorRepository.save(obj);
		return obj;
	}
	
	public List<Colaborador> findByNome(String nome){
		return colaboradorRepositoryImpl.findByNome(nome);
	}

	public Colaborador editar(Colaborador obj) {
		//Colaborador newObj = find(colaborador.getId());
		colaboradorRepository.save(obj);
		return obj;
		
		
	}
	
}
