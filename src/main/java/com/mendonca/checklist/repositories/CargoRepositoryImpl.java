package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.Cargo;

@Repository
public abstract class CargoRepositoryImpl {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Cargo> findByName(String nome){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM Cargo obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<Cargo> query = entityManager.createQuery(consultvalue.toString(), Cargo.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	public Cargo findById(Integer id) {			
			Query query = entityManager.createQuery("SELECT obj FROM Cargo obj WHERE obj.id = :id");
			query.setParameter("id", "%"+id+"%");
			return (Cargo) query.getSingleResult();
	}
	
	public Integer findByDepartamento(Integer id){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj.id_departamento_fk FROM Cargo obj WHERE obj.id= :id");
		Query query = entityManager.createQuery(consultvalue.toString(), Cargo.class);
		query.setParameter("nome", "%"+id+"%");
		return (Integer) query.getSingleResult();
	}

}
