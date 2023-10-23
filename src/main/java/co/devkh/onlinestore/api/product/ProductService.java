package co.devkh.onlinestore.api.product;

import co.devkh.onlinestore.api.product.web.CreateProductDto;
import co.devkh.onlinestore.api.product.web.ProductDto;
import co.devkh.onlinestore.api.product.web.UpdateProductDto;

import java.util.List;

public interface ProductService {

    void createNew(CreateProductDto createProductDto);

    void updateByUuid(String uuid, UpdateProductDto updateProductDto);

    void deleteByUuid(String uuid);

    List<ProductDto> findAll();

    ProductDto findByUuid(String uuid);
}
