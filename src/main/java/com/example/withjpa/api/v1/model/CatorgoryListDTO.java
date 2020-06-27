package com.example.withjpa.api.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatorgoryListDTO {
    private List<CategoryDTO> categories;

    // !!! add to fix reason: actual and formal argument lists differ in length.
    // @AllArgsConstructor
    // public CatorgoryListDTO(List<CategoryDTO> categoryDTOs) {
    // this.categories = categories;
    // }

}