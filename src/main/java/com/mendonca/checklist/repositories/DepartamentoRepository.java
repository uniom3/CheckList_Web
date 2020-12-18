package com.mendonca.checklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendonca.checklist.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
}
