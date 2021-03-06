package com.example.withjpa.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.withjpa.api.v1.model.CategoryDTO;
import com.example.withjpa.domain.Category;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CategoryMapperTest {
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public String Name = "Fruits";
    public long Id = 1L;

    @Test
    public void categoryToCategoryDTO() throws Exception {
        Category category = new Category();
        category.setName(Name);
        category.setId(Id);
        log.debug("categoryToCategoryDTO test start");

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        assertEquals(Id, categoryDTO.getId());
        assertEquals(Name, categoryDTO.getName());
    }
}