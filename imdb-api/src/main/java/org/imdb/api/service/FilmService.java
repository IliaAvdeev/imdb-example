package org.imdb.api.service;

import org.imdb.model.domain.Film;

import java.util.List;

public interface FilmService extends CRUDService<Film> {
    List<Film> getAll(String name);
}