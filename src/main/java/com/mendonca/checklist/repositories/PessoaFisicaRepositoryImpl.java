package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.PessoaFisica;

@Repository
public class PessoaFisicaRepositoryImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	StringBuilder consultvalue = new StringBuilder();
	PessoaFisica pessoaFisica = new PessoaFisica();

	public List<PessoaFisica> findByName(String nome) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM PessoaFisica obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<PessoaFisica> query = entityManager.createQuery(consultvalue.toString(), PessoaFisica.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}
	
	public List<PessoaFisica> findByCpf(String cpf) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM PessoaFisica obj WHERE obj.cpf LIKE :cpf ORDER BY obj.nome");
		TypedQuery<PessoaFisica> query = entityManager.createQuery(consultvalue.toString(), PessoaFisica.class);
		query.setParameter("cpf", "%" + cpf + "%");
		return query.getResultList();
	}
}
