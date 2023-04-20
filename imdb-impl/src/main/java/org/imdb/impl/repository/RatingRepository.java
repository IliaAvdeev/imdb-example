package org.imdb.impl.repository;

import org.imdb.model.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, UUID> {
    List<Rating> findByFilmIdIn(List<UUID> filmIds);
}