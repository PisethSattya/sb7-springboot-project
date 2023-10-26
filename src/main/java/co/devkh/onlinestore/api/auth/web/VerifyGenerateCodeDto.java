package co.devkh.onlinestore.api.auth.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record VerifyGenerateCodeDto(@NotBlank
                                    @Email
                                    String email,
                                    @NotBlank
                                    String verifiedCode) {
}
