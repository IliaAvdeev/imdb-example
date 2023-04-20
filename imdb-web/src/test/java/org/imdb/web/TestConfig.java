package org.imdb.web;

import org.imdb.impl.repository.FilmRepository;
import org.imdb.impl.repository.RatingRepository;
import org.imdb.impl.repository.UserRepository;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@SpringBootConfiguration
@ComponentScan({"org.imdb.impl", "org.imdb.web", "org.imdb.model"})
public class TestConfig {
    @MockBean
    public FilmRepository filmRepository;
    @MockBean
    public RatingRepository ratingRepository;
    @MockBean
    public UserRepository userRepository;
}
