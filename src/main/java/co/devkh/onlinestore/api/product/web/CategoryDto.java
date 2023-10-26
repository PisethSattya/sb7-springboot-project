package co.devkh.onlinestore.api.product.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDto(@NotBlank
                          String name,
                          @NotBlank
                          @Size(min = 5)
                          String description) {
}
