package org.imdb.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingPrimaryKey implements Serializable {
    private UUID userId;
    private UUID filmId;
}