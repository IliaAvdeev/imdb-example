package org.imdb.api.service;

import org.imdb.model.domain.Rating;

import java.util.List;
import java.util.UUID;

public interface RatingService extends CRUDService<Rating> {
    List<Rating> getByFilmIds(List<UUID> filmIds);
}