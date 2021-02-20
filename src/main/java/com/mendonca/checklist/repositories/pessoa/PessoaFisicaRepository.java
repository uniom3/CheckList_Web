package com.mendonca.checklist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendonca.checklist.entities.PessoaFisica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

	@Query(name = "SELECT OBJ FROM PESSOAFISICA OBJ WHERE OBJ.NOME LIKE :nome")
	List<PessoaFisica> findByNome(@Param("nome") String nome);

	@Query(name = "SELECT OBJ FROM PESSOAFISICA OBJ WHERE OBJ.CPF LIKE :cpf")
	PessoaFisica findByCpf(@Param("cpf") String cpf);
}
