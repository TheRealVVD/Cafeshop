package com.example.cafeshop.web.mappers;

import com.example.cafeshop.domain.user.User;
import com.example.cafeshop.web.dto.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    List<UserDto> toDto(List<User> users);
    User toEntity(UserDto userDto);
    List<User> toEntity(List<UserDto> userDtos);

}
