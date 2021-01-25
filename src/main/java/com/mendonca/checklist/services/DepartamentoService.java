package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.checklist.entities.Departamento;
import com.mendonca.checklist.repositories.DepartamentoRepository;
import com.mendonca.checklist.repositories.DepartamentoRepositoryImpl;
import com.mendonca.checklist.services.exceptions.ObjectNotFoundException;

@Service
public class DepartamentoService {

	
	private DepartamentoRepositoryImpl departamentoRepositoryImpl;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	

	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}

	public Departamento findById(Long id) {
		Optional<Departamento> obj = departamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Departamento.class.getName()));
	}

	public List<Departamento> findByName(String nome) {
		return departamentoRepositoryImpl.findByName(nome);
	}

	public Departamento insert(Departamento obj) {
		obj.setId(null);
		return departamentoRepository.save(obj);
	}

	public Departamento editar(Departamento obj) {
		departamentoRepository.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		departamentoRepository.deleteById(id);
	}

	public boolean departamentoTemCargos(Long id) {
		if (findById(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
	

}
