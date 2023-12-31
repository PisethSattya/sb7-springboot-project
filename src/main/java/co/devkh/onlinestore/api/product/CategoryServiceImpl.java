package co.devkh.onlinestore.api.product;

import co.devkh.onlinestore.api.product.web.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository  categoryRepository;
    private final CategoryMapper categoryMapper;
    @Transactional
    @Override
    public void createNew(CategoryDto categoryDto) {
        Category category = categoryMapper.fromCategoryDto(categoryDto);
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toCategoryDtoList(categories);
    }

    @Override
    public CategoryDto findByName(String name) {
        Category category = categoryRepository.findByName(name).orElseThrow();
        //  Category category = categoryRepository.findByNameContainingIgnoreCase(name).orElseThrow();
        return categoryMapper.toCategoryDto(category);
    }
}
