package com.example.withjpa.controllers.v1;

import com.example.withjpa.api.v1.model.CategoryDTO;
import com.example.withjpa.api.v1.model.CatorgoryListDTO;
import com.example.withjpa.services.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/categories/")
public class CategoryController {
    // public static final String BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CatorgoryListDTO> getallCatetories() {

        return new ResponseEntity<CatorgoryListDTO>(new CatorgoryListDTO(categoryService.getAllCategories()),
                HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
        return new ResponseEntity<CategoryDTO>(categoryService.getCategoryByName(name), HttpStatus.OK);
    }
}