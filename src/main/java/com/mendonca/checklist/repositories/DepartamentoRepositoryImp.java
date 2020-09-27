package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.Departamento;

@Repository
public class DepartamentoRepositoryImp {

	@PersistenceContext
	EntityManager entityManager;

	public List<Departamento> findByNome(String nome) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM Departamento obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<Departamento> query = entityManager.createQuery(consultvalue.toString(), Departamento.class);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
	public Departamento findById(Integer id){		
		Query query = entityManager.createQuery("select obj from Departamento obj where obj.id = :id");
		query.setParameter("id", id);
		return (Departamento) query.getSingleResult();
	}
}
