package ru.job4j.mapper;

import org.mapstruct.Mapper;
import ru.job4j.dto.UserDto;
import ru.job4j.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserDto userDto);

    UserDto map(User user);
}
