package com.mendonca.checklist.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checklist.entities.Pessoa;
import com.mendonca.checklist.repositories.PessoaRepository;
import com.mendonca.checklist.repositories.PessoaRepositoryImpl;

@Service
public class PessoaService {

	private PessoaRepositoryImpl pessoaRepositoryImpl;
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		return pessoaRepositoryImpl.findAll();
	}

	public Optional<Pessoa> findById(Long id) {
		return pessoaRepositoryImpl.findById(id);
	}

	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		pessoaRepository.save(obj);
		return obj;
	}

	public Pessoa editar(Pessoa obj) {
		pessoaRepository.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		pessoaRepositoryImpl.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<Pessoa> buscarPorId(Long id) {		
		return pessoaRepositoryImpl.findById(id);
	}

}
