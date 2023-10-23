package co.devkh.onlinestore.api.product.web;

public record ProductDto(String uuid,
                         String code,
                         String name,
                         String image,
                         String category) {
}
