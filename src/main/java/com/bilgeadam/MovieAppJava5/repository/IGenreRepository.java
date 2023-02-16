package com.bilgeadam.MovieAppJava5.repository;

import com.bilgeadam.MovieAppJava5.repository.entity.Genre;
import com.bilgeadam.MovieAppJava5.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IGenreRepository extends JpaRepository<Genre,Long> {

   Optional<Genre> findOptionalByName(String name);



}
