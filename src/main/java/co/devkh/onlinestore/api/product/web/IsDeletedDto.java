package co.devkh.onlinestore.api.product.web;

import jakarta.validation.constraints.NotNull;

public record IsDeletedDto(@NotNull
                           Boolean isDeleted) {
}
