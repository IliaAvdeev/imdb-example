package org.imdb.impl.mapper;

import org.imdb.model.domain.User;
import org.imdb.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends DtoMapper<UserDto, User> {}