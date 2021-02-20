package com.mendonca.checklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.PessoaJuridica;

import java.util.List;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long>{

    @Query(name = "SELECT OBJ FROM PESSOAJURIDICA OBJ WHERE OBJ.NOME LIKE :nome")
    List<PessoaJuridica> findByNome(@Param("nome") String nome);

    @Query(name = "SELECT OBJ FROM PESSOAJURIDICA OBJ WHERE OBJ.RAZASOCIAL LIKE :razaoSocial")
    List<PessoaJuridica> findByRazaoSocial(@Param("razaoSocial") String razao);

    @Query(name = "SELECT OBJ FROM PESSOAJURIDICA OBJ WHERE OBJ.CNPJ LIKE :cnpj")
    List<PessoaJuridica> findByCnpj(@Param("cnpj") String cnpj);
}
