package org.imdb.web;

import org.imdb.api.service.RatingService;
import org.imdb.impl.mapper.RatingMapper;
import org.imdb.model.dto.RatingDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingMapper ratingMapper;
    private final RatingService ratingService;

    public RatingController(RatingMapper ratingMapper, RatingService ratingService) {
        this.ratingMapper = ratingMapper;
        this.ratingService = ratingService;
    }

    @PostMapping("/rate")
    public RatingDto create(@RequestBody RatingDto ratingDto) {
        return ratingMapper.toDto(ratingService.create(ratingMapper.toDomain(ratingDto)));
    }
}