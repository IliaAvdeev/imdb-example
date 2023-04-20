package org.imdb.impl.mapper;

import org.imdb.model.domain.Rating;
import org.imdb.model.dto.RatingDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RatingMapper extends DtoMapper<RatingDto, Rating> {}