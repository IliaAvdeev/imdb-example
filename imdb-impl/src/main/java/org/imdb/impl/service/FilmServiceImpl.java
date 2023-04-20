package org.imdb.impl.service;

import org.imdb.api.service.FilmService;
import org.imdb.api.service.RatingService;
import org.imdb.impl.repository.FilmRepository;
import org.imdb.model.domain.Film;
import org.imdb.model.domain.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("filmService")
public class FilmServiceImpl extends CRUDServiceImpl<Film> implements FilmService {
    private final FilmRepository filmRepository;
    private final RatingService ratingService;

    public FilmServiceImpl(FilmRepository filmRepository, RatingService ratingService) {
        this.filmRepository = filmRepository;
        this.ratingService = ratingService;
    }

    @Override
    public List<Film> getAll(String name) {
        return name == null ? getAll() : postGetAll(filmRepository.findByName(name));
    }

    @Override
    protected List<Film> postGetAll(List<Film> films) {
        List<UUID> ids = films.stream()
                .map(Film::getId)
                .toList();
        Map<UUID, Double> filmRating = ratingService.getByFilmIds(ids)
                .stream()
                .collect(Collectors.groupingBy(Rating::getFilmId, Collectors.averagingDouble(Rating::getRating)));
        films.forEach(film -> film.setRating(filmRating.get(film.getId())));
        return super.postGetAll(films);
    }
}