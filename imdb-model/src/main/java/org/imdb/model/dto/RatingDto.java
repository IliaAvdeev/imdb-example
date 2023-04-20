package org.imdb.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class RatingDto {
    @NonNull
    private UUID filmId;
    @NonNull
    private UUID userId;
    @NonNull
    private Integer rating;
}