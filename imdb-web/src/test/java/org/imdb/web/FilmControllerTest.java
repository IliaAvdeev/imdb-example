package org.imdb.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.imdb.impl.repository.FilmRepository;
import org.imdb.model.domain.Film;
import org.imdb.model.dto.FilmDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FilmController.class)
public class FilmControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private FilmRepository filmRepository;
    private FilmDto filmDto;

    @BeforeEach
    public void setUp() {
        filmDto = new FilmDto("Gattaka", List.of("Action"), List.of("John"), 2000, List.of("Germany"));
        Film film = new Film("Gattaka", List.of("Action"), List.of("John"), 2000, List.of("Germany"));
        doReturn(film).when(filmRepository).save(any());
    }

    @Test
    public void testCreateFilm() throws Exception {
        mvc.perform(post("/film")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(filmDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllFilms() throws Exception {
        mvc.perform(get("/film"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
    }

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}