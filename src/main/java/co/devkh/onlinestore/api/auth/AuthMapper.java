package co.devkh.onlinestore.api.auth;

import co.devkh.onlinestore.api.auth.web.RegisterDto;
import co.devkh.onlinestore.api.user.web.NewUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    NewUserDto mapRegisterDtoToNewUserDto(RegisterDto registerDto);
}
