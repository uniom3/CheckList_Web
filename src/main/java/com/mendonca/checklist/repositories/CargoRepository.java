package com.mendonca.checklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.checklist.entities.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
