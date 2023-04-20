package org.imdb.impl.mapper;

import org.imdb.model.domain.Film;
import org.imdb.model.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FilmMapper extends DtoMapper<FilmDto, Film> {
    @Override
    @Mapping(target = "rating", ignore = true)
    Film toDomain(FilmDto filmDto);

    @Override
    @Mapping(target = "rating", numberFormat = "#.00")
    FilmDto toDto(Film film);
}