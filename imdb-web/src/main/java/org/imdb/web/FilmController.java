package org.imdb.web;

//import jakarta.servlet.http.HttpServletRequest;

import org.imdb.api.service.FilmService;
import org.imdb.impl.mapper.FilmMapper;
import org.imdb.model.dto.FilmDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    private final FilmService filmService;
    private final FilmMapper filmMapper;

    public FilmController(FilmService filmService, FilmMapper filmMapper) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FilmDto create(@RequestBody FilmDto newFilm) {
        return filmMapper.toDto(filmService.create(filmMapper.toDomain(newFilm)));
    }

    @GetMapping
    @ResponseBody
    public List<FilmDto> getAll(@RequestParam(value = "name", required = false) String name) {
        return filmMapper.toDto(filmService.getAll(name));
    }
}