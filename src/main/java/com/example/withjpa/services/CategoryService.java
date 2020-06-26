package com.example.withjpa.services;

import java.util.List;

import com.example.withjpa.api.v1.model.CategoryDTO;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}