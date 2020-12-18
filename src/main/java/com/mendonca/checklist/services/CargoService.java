package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.repositories.CargoRepositoryImpl;

@Service
public class CargoService {

	
	private CargoRepositoryImpl cargoRepositoryImpl;

	public List<Cargo> findAll() {
		return cargoRepositoryImpl.findAll();
	}

	public Optional<Cargo> findById(Long id) {
		return cargoRepositoryImpl.findById(id);
	}

	public List<Cargo> findByName(String nome) {
		return cargoRepositoryImpl.findByName(nome);
	}

	public Cargo insert(Cargo obj) {
		obj.setId(null);
		cargoRepositoryImpl.save(obj);
		return obj;
	}

	public Cargo editar(Cargo obj) {
		cargoRepositoryImpl.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		cargoRepositoryImpl.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Cargo buscarPorId(Integer id) {
		return cargoRepositoryImpl.findById(id);
	}

	public boolean cargoTemFuncionarios(Integer id) {
		if (buscarPorId(id).getColaborador().isEmpty()) {
			return false;
		}
		return true;
	}
}
