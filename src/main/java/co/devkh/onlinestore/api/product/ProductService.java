package co.devkh.onlinestore.api.product;

import co.devkh.onlinestore.api.product.web.CreateProductDto;
import co.devkh.onlinestore.api.product.web.ProductDto;
import co.devkh.onlinestore.api.product.web.UpdateProductDto;

import java.util.List;

public interface ProductService {

    /**
     * This method is used to create a new product
     * resource into database
     * @param createProductDto is the request data from client
     */
    void createNew(CreateProductDto createProductDto);

    /**
     * This method is used to update(Partially Update) product by uuid
     * @param uuid of product
     * @param updateProductDto is the request data from client for update
     */
    void updateByUuid(String uuid, UpdateProductDto updateProductDto);

    /**
     * This method is used to delete product from database by uuid
     * @param uuid of product
     */
    void deleteByUuid(String uuid);

    /**
     * This method is used to retrieve resource product from database
     * @return List<ProductDto>
     */
    List<ProductDto> findAll();

    /**
     * This method is used to retrieve resource product by uuid
     * from database
     * @param uuid of product
     * @return ProductDto
     */
    ProductDto findByUuid(String uuid);
}
