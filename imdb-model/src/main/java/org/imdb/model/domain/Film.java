package org.imdb.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film")
@RequiredArgsConstructor
public class Film {
    @Id
    @GeneratedValue
    private UUID id;
    @NonNull
    private String name;
    @Transient
    private Double rating;
    @NonNull
    private List<String> genres;
    @NonNull
    private List<String> directors;
    @NonNull
    private Integer yearOfCreation;
    @NonNull
    private List<String> countriesOfCreation;
}