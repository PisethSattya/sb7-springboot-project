package co.devkh.onlinestore.api.product;

import co.devkh.onlinestore.api.product.web.CreateProductDto;
import co.devkh.onlinestore.api.product.web.ProductDto;
import co.devkh.onlinestore.api.product.web.UpdateProductDto;
import co.devkh.onlinestore.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Transactional
    @Override
    public void createNew(CreateProductDto createProductDto) {
        Product product = productMapper.fromCreateProductDto(createProductDto);
        product.setUuid(UUID.randomUUID().toString());
        product.setCode("PRO-"+ RandomUtil.generateCode());
        productRepository.save(product);
    }
    @Transactional
    @Override
    public void updateByUuid(String uuid, UpdateProductDto updateProductDto) {
        // Step 1: Check uuid of product in the database
        if (productRepository.existsByUuid(uuid)){

            // Step 2: Load old product
            Product product = productRepository.findByUuid(uuid)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            String.format("Product UUID = %s doesn't exist in db!",uuid)));

            // Step 3: Map updating product partially
            productMapper.fromUpdateProductDto(product,updateProductDto);

            if (updateProductDto.categoryId() != null){

                Category newCategory = new Category();
                newCategory.setId(updateProductDto.categoryId());
                product.setCategory(newCategory);
            }

            // Step 4: Save latest product
            productRepository.save(product);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Product UUID = %s doesn't exist in db!",uuid));
    }
    @Transactional
    @Override
    public void deleteByUuid(String uuid) {
        Product product = productRepository.findByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Product UUID = %s doesn't exist in db!",uuid)));
        productRepository.delete(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDto(products);
      //  return productMapper.toProductDto(productRepository.findAll());
    }

    @Override
    public ProductDto findByUuid(String uuid) {
         Product product = productRepository.findByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Product UUID = %s doesn't exist in db!",uuid)));

               return productMapper.toProductDto(product);
    }
}
