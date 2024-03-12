package com.evaaguilera.Ecommerce.backend.infrastructure.mapper;

import com.evaaguilera.Ecommerce.backend.domain.model.Category;
import com.evaaguilera.Ecommerce.backend.infrastructure.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings(
            {
                    @Mapping(source = "id",target = "id"),
                    @Mapping(source = "name",target = "name"),
                    @Mapping(source = "dateCreated",target = "dateCreated"),
                    @Mapping(source = "dateUpdated",target = "dateUpdated")

            }
    )
    Category toCategory(CategoryEntity category);
    Iterable<Category> toCategoryList(Iterable<CategoryEntity> categoryEntities);
@InheritInverseConfiguration
    CategoryEntity toCategoryEntity(Category category);
}
