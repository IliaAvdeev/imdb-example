package org.imdb.impl.repository;

import org.imdb.model.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
    List<Film> findByName(String name);
}