package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.Colaborador;

@Repository
public class ColaboradorRepositoryImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	StringBuilder consultvalue = new StringBuilder();
	Colaborador colaborador = new Colaborador();

	public List<Colaborador> findByNome(String nome) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM Colaborador obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<Colaborador> query = entityManager.createQuery(consultvalue.toString(), Colaborador.class);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

/*	public byte[] findByimage(Integer id) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj.imagem FROM Colaborador obj WHERE obj.id = id");
		TypedQuery<Colaborador> query = entityManager.createQuery(consultvalue.toString(), Colaborador.class);
		query.setParameter("id", "%" + id + "%");
		return colaborador.getImagem();
	}*/

	public List<Colaborador> findByCargoId(Integer id) {
		consultvalue.append("select f from Colaborador f where f.cargo.id = :id");
		TypedQuery<Colaborador> query = entityManager.createQuery(consultvalue.toString(), Colaborador.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public Object excluirimagem(Integer id) {
		consultvalue.append("select f from Colaborador f where f.id = :id");
		Query query = entityManager.createQuery(consultvalue.toString(), Colaborador.class);
		query.setParameter("id", id );		
		return query.getSingleResult();
	}
	
/*	public void ativo(Boolean opcao, Integer id) {
		consultvalue.append("select f from Colaborador f where f.id = :id");
		Query query = entityManager.createQuery(consultvalue.toString(), Colaborador.class);
		query.setParameter("id", id);
		query.getSingleResult();
		System.out.println("Query"+query.getSingleResult());
		colaborador.setAtivo(opcao);		
	}*/
}
