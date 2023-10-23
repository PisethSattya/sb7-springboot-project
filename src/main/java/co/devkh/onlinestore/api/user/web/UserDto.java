package co.devkh.onlinestore.api.user.web;

public record UserDto(String uuid,
                      String username,
                      String email,
                      String nickname
                      ) {
}
