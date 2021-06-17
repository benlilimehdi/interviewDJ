package com.example.entrevueSpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entrevueSpringBoot.entity.Acteur;

@Repository
public interface ActeurRepository extends CrudRepository <Acteur, Long> {
	
	/*
	@Query(value="SELECT * FROM Acteur a WHERE nom like :P1 and prenom like :P2", nativeQuery = true)
	public List<Acteur> getByFirstAndLastName(@Param("P1") String nom,@Param("P2")  String prenom);
	*/
}
