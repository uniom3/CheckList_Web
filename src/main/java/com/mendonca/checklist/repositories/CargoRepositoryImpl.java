package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.Cargo;

@Repository
public class CargoRepositoryImpl {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Cargo> findByNome(String nome){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM Cargo obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<Cargo> query = entityManager.createQuery(consultvalue.toString(), Cargo.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	
	public Cargo findById(Integer id){	
		Query query = entityManager.createQuery("select obj from Cargo obj where obj.id = :id");
		query.setParameter("id", id);
		return (Cargo) query.getSingleResult();
	}

}
