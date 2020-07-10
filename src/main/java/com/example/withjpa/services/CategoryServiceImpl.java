package com.example.withjpa.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.withjpa.api.v1.mapper.CategoryMapper;
import com.example.withjpa.api.v1.model.CategoryDTO;
import com.example.withjpa.exceptions.NotFoundException;
import com.example.withjpa.repositories.CategoryRepository;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        // return categoryMapper.categoryToCategoryDTO(categoryRepository.findAll());
        // Argument : Category

        // staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
        if (categoryDTO == null) {
            throw new NotFoundException("given resource not found");
        }
        return categoryDTO;
    }
}