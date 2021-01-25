package com.mendonca.checklist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checklist.entities.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Pessoa obj WHERE obj.nome LIKE :nome ORDER BY obj.nome")
	public List<PessoaFisica> findByName(@Param("nome") String nome);

}
