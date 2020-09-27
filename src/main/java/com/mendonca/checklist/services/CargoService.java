package com.mendonca.checklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.repositories.CargoRepository;
import com.mendonca.checklist.repositories.CargoRepositoryImpl;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	

	@Autowired
	private CargoRepositoryImpl cargoRepositoryImpl;

	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	public Cargo findById(Integer id) {
		
		return cargoRepositoryImpl.findById(id);
	}

	public List<Cargo> findByNome(String nome) {
		return cargoRepositoryImpl.findByNome(nome);
	}

	public Cargo insert(Cargo obj) {
		obj.setId(null);
		cargoRepository.save(obj);
		return obj;
	}

	public Cargo editar(Cargo obj) {
		cargoRepository.save(obj);
		return obj;
	}

	public void excluir(Integer id) {
		cargoRepository.deleteById(id);
	}
	
	public boolean cargoTemFuncionarios(Integer id) {
		if ( findById(id).getColaborador().isEmpty()) {
			return false;
		}
		return true;
	}
}
