package com.example.withjpa.controllers.v1;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.withjpa.api.v1.model.CategoryDTO;
import com.example.withjpa.exceptions.NotFoundException;
import com.example.withjpa.services.CategoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    String Name1 = "aa";
    String Name2 = "bb";
    Long Id1 = 1l;
    Long Id2 = 2l;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void getallCatetories() throws Exception {
        CategoryDTO category1 = new CategoryDTO();
        category1.setId(Id1);
        category1.setName(Name1);
        CategoryDTO category2 = new CategoryDTO();
        category2.setId(Id2);
        category2.setName(Name2);
        log.debug("controller getallCatetories test start");

        List<CategoryDTO> categories = Arrays.asList(category1, category2);
        when(categoryService.getAllCategories()).thenReturn(categories);

        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html
        // https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/web/servlet/ResultActions.html
        mockMvc.perform(get(BaseUrl.Cateogry_BASE_URL)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.categories.length()").value(categories.size()));

        // https://stackoverflow.com/questions/15371022/springmvc-mockmvc-jsonpath-compare-list-of-strings
        // https://stackoverflow.com/questions/42725199/how-to-use-mockmvcresultmatchers-jsonpath
        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/result/MockMvcResultMatchers.html
    }

    @Test
    public void CategoryDTO() throws Exception {
        CategoryDTO category1 = new CategoryDTO();
        category1.setId(Id1);
        category1.setName(Name1);
        log.debug("controller CategoryDTO test start");

        when(categoryService.getCategoryByName(anyString())).thenReturn(category1);

        mockMvc.perform(get(BaseUrl.Cateogry_BASE_URL + "/bb")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(Name1));

    }

    @Test
    public void CategoryDTONotFound() throws Exception {
        log.debug("thrown expection is implemented by myself");

        when(categoryService.getCategoryByName(anyString())).thenThrow(NotFoundException.class);
        mockMvc.perform(get(BaseUrl.Cateogry_BASE_URL + "/bb")).andExpect(status().isNotFound());

    }
}