package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checklist.entities.PessoaFisica;
import com.mendonca.checklist.repositories.PessoaFisicaRepository;
import com.mendonca.checklist.repositories.PessoaFisicaRepositoryImpl;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired
	private PessoaFisicaRepositoryImpl pessoaFisicaRepositoryImpl;
		
	public List<PessoaFisica> findAll() {
		return pessoaFisicaRepository.findAll();
	}

	public Optional<PessoaFisica> findById(Long id) {
		return pessoaFisicaRepository.findById(id);
	}

	public PessoaFisica insert(PessoaFisica obj) {
		obj.setId(null);
		try {
			pessoaFisicaRepository.save(obj);
		} catch (Exception e) {
			e.getMessage();
		}
		return obj;
	}

	public PessoaFisica editar(PessoaFisica obj) {
		pessoaFisicaRepository.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		pessoaFisicaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Optional<PessoaFisica> buscarPorId(Long id) {
		return pessoaFisicaRepository.findById(id);
	}

	public PessoaFisica find(Long id) throws ObjectNotFoundException {
		Optional<PessoaFisica> obj = pessoaFisicaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PessoaFisica.class.getName()));
	}

	/*
	public List<PessoaFisica> findbyCPF(String cpf) throws ObjectNotFoundException {
		List<PessoaFisica> obj = pessoaFisicaRepository.findByCPF(cpf);
		return obj;

	}
	*/
	public List<PessoaFisica> findByName(String nome){
		return pessoaFisicaRepositoryImpl.findByName(nome);
	}

	public List<PessoaFisica> findByCpf(String cpf){
		return pessoaFisicaRepositoryImpl.findByCpf(cpf);
	}

}
