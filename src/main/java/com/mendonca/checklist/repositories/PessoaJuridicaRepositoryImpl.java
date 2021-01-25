package com.mendonca.checklist.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.PessoaJuridica;

@Repository
public class PessoaJuridicaRepositoryImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	StringBuilder consultvalue = new StringBuilder();
	PessoaJuridica pessoaFisica = new PessoaJuridica();
	
	public List<PessoaJuridica> findByName(String nome){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM PessoaJuridica obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<PessoaJuridica> query = entityManager.createQuery(consultvalue.toString(), PessoaJuridica.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	public List<PessoaJuridica> findByRazao(String razao){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM PessoaJuridica obj WHERE obj.razaoSocial LIKE :razaoSocial ORDER BY obj.razaoSocial");
		TypedQuery<PessoaJuridica> query = entityManager.createQuery(consultvalue.toString(), PessoaJuridica.class);
		query.setParameter("razaoSocial", "%"+razao+"%");
		return query.getResultList();
	}
	
	public List<PessoaJuridica> findByCNPJ(String cnpj){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM PessoaJuridica obj WHERE obj.cnpj LIKE :cnpj ORDER BY obj.nome");
		TypedQuery<PessoaJuridica> query = entityManager.createQuery(consultvalue.toString(), PessoaJuridica.class);
		query.setParameter("cnpj", "%"+cnpj+"%");
		return query.getResultList();
	}

}
