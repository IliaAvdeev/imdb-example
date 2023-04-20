package org.imdb.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "rating")
@RequiredArgsConstructor
@IdClass(RatingPrimaryKey.class)
public class Rating {
    @Id
    @NonNull
    private UUID userId;
    @Id
    @NonNull
    private UUID filmId;
    @NonNull
    private Integer rating;
}