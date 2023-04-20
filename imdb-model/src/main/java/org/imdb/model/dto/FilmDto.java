package org.imdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class FilmDto {
    private UUID id;
    @NonNull
    private String name;
    private String rating;
    @NonNull
    private List<String> genres;
    @NonNull
    private List<String> directors;
    @NonNull
    private Integer yearOfCreation;
    @NonNull
    private List<String> countriesOfCreation;
}