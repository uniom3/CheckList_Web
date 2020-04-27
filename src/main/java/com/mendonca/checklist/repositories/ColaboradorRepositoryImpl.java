package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.Colaborador;

@Repository
public class ColaboradorRepositoryImpl {

	@PersistenceContext
    EntityManager entityManager;

    public List<Colaborador> findByNome(String nome){ 
        StringBuilder consultvalue = new StringBuilder();
        consultvalue.append("SELECT obj FROM Colaborador obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
        TypedQuery<Colaborador> query = entityManager.createQuery(consultvalue.toString(), Colaborador.class);
        query.setParameter("nome", "%"+nome+"%");

        return query.getResultList();
    }
	
	
}
