package com.example.withjpa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.withjpa.api.v1.mapper.CategoryMapper;
import com.example.withjpa.api.v1.model.CategoryDTO;
import com.example.withjpa.domain.Category;
import com.example.withjpa.repositories.CategoryRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// https://www.baeldung.com/mockito-junit-5-extension
// https://stackoverflow.com/questions/40961057/how-to-use-mockito-with-junit5
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;
    public String Name = "Fruits";
    public Long Id = 1L;

    @BeforeEach
    public void setUp() throws Exception {
        // MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() throws Exception {
        List<Category> categories = Arrays.asList(new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);
        log.debug("getAllCategories test start");

        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        assertEquals(2, categoryDTOS.size());
    }

    // return CategoryDTO
    @Test
    public void getCategoryByName() throws Exception {
        Category category = new Category();
        category.setId(Id);
        category.setName(Name);
        when(categoryRepository.findByName(anyString())).thenReturn(category);
        log.debug("getCategoryByName test start");

        CategoryDTO categoryDTO = categoryService.getCategoryByName(Name);

        assertEquals(Id, categoryDTO.getId());
        assertEquals(Name, categoryDTO.getName());
    }
}