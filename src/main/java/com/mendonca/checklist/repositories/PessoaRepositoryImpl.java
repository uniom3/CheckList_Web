package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mendonca.checklist.entities.Pessoa;


public abstract  class PessoaRepositoryImpl implements PessoaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Pessoa> findByName(String nome){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM Pessoa obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<Pessoa> query = entityManager.createQuery(consultvalue.toString(), Pessoa.class);
		query.setParameter("nome", "%"+nome+"%");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

}
