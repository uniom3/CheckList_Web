package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.repositories.CargoRepository;
import com.mendonca.checklist.repositories.CargoRepositoryImpl;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	private CargoRepositoryImpl cargoRepositoryImpl;

	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	public Optional<Cargo> findById(Long id) {
		return cargoRepository.findById(id);
	}

	public List<Cargo> findByName(String nome) {
		return cargoRepositoryImpl.findByName(nome);
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

	public void excluir(Long id) {
		cargoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Cargo buscarPorId(Integer id) {
		return cargoRepositoryImpl.findById(id);
	}

	public boolean cargoTemColaborador(Integer id) {
		if (buscarPorId(id).getColaborador().isEmpty()) {
			return false;
		}
		return true;
	}
}
