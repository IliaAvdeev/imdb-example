package org.imdb.impl.service;

import org.imdb.api.service.RatingService;
import org.imdb.impl.repository.FilmRepository;
import org.imdb.impl.repository.RatingRepository;
import org.imdb.model.domain.Film;
import org.imdb.model.domain.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("ratingService")
public class RatingServiceImpl extends CRUDServiceImpl<Rating> implements RatingService {
    private final RatingRepository ratingRepository;
    private final FilmRepository filmRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, FilmRepository filmRepository) {
        this.ratingRepository = ratingRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Rating> getByFilmIds(List<UUID> filmIds) {
        return ratingRepository.findByFilmIdIn(filmIds);
    }

    @Override
    public Rating create(Rating rating) {
        Rating newRating = super.create(rating);
        UUID filmId = rating.getFilmId();
        Film film = filmRepository.findById(filmId).get();

        List<Rating> ratings = getByFilmIds(List.of(filmId));
        ratings.add(newRating);

        Map<UUID, Double> collect = ratings.stream()
                .collect(Collectors.groupingBy(Rating::getFilmId, Collectors.averagingDouble(Rating::getRating)));

        long count = ratings.stream().count();
        Integer newRatingValue = newRating.getRating();
        film.setRating((film.getRating() + newRatingValue)/count);

        filmRepository.save(film);
        return newRating;
    }
}