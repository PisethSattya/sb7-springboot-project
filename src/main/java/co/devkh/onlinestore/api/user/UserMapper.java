package co.devkh.onlinestore.api.user;

import co.devkh.onlinestore.api.user.web.NewUserDto;
import co.devkh.onlinestore.api.user.web.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User fromNewUserDto(NewUserDto newUserDto);
}
