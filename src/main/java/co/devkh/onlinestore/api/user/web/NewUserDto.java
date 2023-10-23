package co.devkh.onlinestore.api.user.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NewUserDto(@NotBlank
                         String username,
                         @NotBlank
                         @Email
                         String email,
                         @NotBlank
                         String password,
                         @NotBlank
                         @Size(min = 4)
                         String nickName
) {
}
