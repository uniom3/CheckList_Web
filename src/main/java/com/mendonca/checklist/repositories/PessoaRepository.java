package com.mendonca.checklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendonca.checklist.entities.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
