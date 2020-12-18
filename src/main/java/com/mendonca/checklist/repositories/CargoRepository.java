package com.mendonca.checklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendonca.checklist.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
