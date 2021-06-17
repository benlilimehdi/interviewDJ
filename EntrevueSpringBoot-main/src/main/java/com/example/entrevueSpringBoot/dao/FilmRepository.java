package com.example.entrevueSpringBoot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entrevueSpringBoot.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

	public Optional<Film> findById(Long filmID);
}
