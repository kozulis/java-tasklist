package ru.milovanov.tasklist.web.mappers;

import org.mapstruct.Mapper;
import ru.milovanov.tasklist.domain.user.User;
import ru.milovanov.tasklist.web.dto.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

}
