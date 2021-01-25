package com.mendonca.checklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checklist.entities.PessoaJuridica;
import com.mendonca.checklist.repositories.PessoaJuridicaRepository;
import com.mendonca.checklist.repositories.PessoaJuridicaRepositoryImpl;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PessoaJuridicaService {

	
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	@Autowired
	private PessoaJuridicaRepositoryImpl pessoaJuridicaRepositoryImpl;
	
	public List<PessoaJuridica> findAll() {
		return pessoaJuridicaRepository.findAll();
	}

	public Optional<PessoaJuridica> findById(Long id) {
		return pessoaJuridicaRepository.findById(id);
	}

	public PessoaJuridica insert(PessoaJuridica obj) {
		obj.setId(null);
		pessoaJuridicaRepository.save(obj);
		return obj;
	}

	public PessoaJuridica editar(PessoaJuridica obj) {
		pessoaJuridicaRepository.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		pessoaJuridicaRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<PessoaJuridica> buscarPorId(Long id) {		
		return pessoaJuridicaRepository.findById(id);
	}

	public PessoaJuridica find(Long id) throws ObjectNotFoundException {
		Optional<PessoaJuridica> obj = pessoaJuridicaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PessoaJuridica.class.getName()));
	}
	
	public List<PessoaJuridica> findByNome(String nome){
		return pessoaJuridicaRepositoryImpl.findByName(nome);
	}
	
	public List<PessoaJuridica> findByRazao(String razao){
		return pessoaJuridicaRepositoryImpl.findByRazao(razao);
	}
	
	public List<PessoaJuridica> findByCnpj(String cnpj){
		return pessoaJuridicaRepositoryImpl.findByCNPJ(cnpj);
	}
	
	
}
