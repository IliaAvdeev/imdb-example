package org.imdb.impl.mapper;

import java.util.List;

public interface DtoMapper<Dto, Domain> {
    Dto toDto(Domain domain);

    Domain toDomain(Dto dto);

    List<Dto> toDto(List<Domain> domains);

    List<Domain> toDomain(List<Dto> domains);
}