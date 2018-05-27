package com.kp.spring.Mapper;

import com.kp.spring.domain.Category;
import com.kp.spring.domain.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category mapToCategory(final CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getType(),
                null
        );
    }

    public CategoryDto mapToCategoryDto (final Category category){
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getType());
    }

    public List<CategoryDto> mapToCategoryDtoList (final List<Category> categoryList){
        return categoryList.stream()
                .map(t -> new CategoryDto(t.getId(), t.getName(), t.getType()))
                .collect(Collectors.toList());
    }
}
