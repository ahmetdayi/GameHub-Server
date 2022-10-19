package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.CategoryIdDoesNotExist;
import com.software.gameHub.core.exception.CategoryNameAlreadyExists;
import com.software.gameHub.dto.CategoryDto;
import com.software.gameHub.dto.CreateCategoryRequest;
import com.software.gameHub.dto.converter.CategoryConverter;
import com.software.gameHub.entity.Category;
import com.software.gameHub.repository.CategoryDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;

    private final CategoryConverter categoryConverter;

    public CategoryService(CategoryDao categoryDao, CategoryConverter categoryConverter) {
        this.categoryDao = categoryDao;
        this.categoryConverter = categoryConverter;
    }

    public CategoryDto create(CreateCategoryRequest request) {
        Optional<Category> category = categoryDao.findCategoryByName(request.getName());

        if (category.isPresent()) {
            throw new CategoryNameAlreadyExists(Constant.CATEGORY_NAME_ALREADY_EXISTS);

        }
        Category category1 = new Category(request.getName());

        return categoryConverter.convert(categoryDao.save(category1));
    }

    public List<CategoryDto> findAll() {
        return categoryConverter.convert(categoryDao.findAll());
    }

    public void delete(int categoryId) {

        categoryDao.deleteById(findById(categoryId).getCategoryId());

    }

    private Category findById(int categoryId) {
        return categoryDao.findById(categoryId).orElseThrow(
                () -> new CategoryIdDoesNotExist(Constant.CATEGORY_ID_DOES_NOT_EXIST));
    }


}

