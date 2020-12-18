package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mendonca.checklist.entities.Departamento;
import com.mendonca.checklist.repositories.DepartamentoRepositoryImpl;
import com.mendonca.checklist.services.exceptions.ObjectNotFoundException;

@Service
public class DepartamentoService {

	
	private DepartamentoRepositoryImpl departamentoRepositoryImpl;
	
	

	public List<Departamento> findAll() {
		return departamentoRepositoryImpl.findAll();
	}

	public Departamento findById(Long id) {
		Optional<Departamento> obj = departamentoRepositoryImpl.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Departamento.class.getName()));
	}

	public List<Departamento> findByName(String nome) {
		return departamentoRepositoryImpl.findByName(nome);
	}

	public Departamento insert(Departamento obj) {
		obj.setId(null);
		return departamentoRepositoryImpl.save(obj);
	}

	public Departamento editar(Departamento obj) {
		departamentoRepositoryImpl.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		departamentoRepositoryImpl.deleteById(id);
	}

	public boolean departamentoTemCargos(Long id) {
		if (findById(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
	

}
