package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.repositories.ColaboradorRepository;
import com.mendonca.checklist.repositories.ColaboradorRepositoryImpl;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ColaboradorRepositoryImpl colaboradorRepositoryImpl;
	

	
	
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
}
