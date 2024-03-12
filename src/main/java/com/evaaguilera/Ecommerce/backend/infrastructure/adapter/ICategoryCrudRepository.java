package com.evaaguilera.Ecommerce.backend.infrastructure.adapter;

import com.evaaguilera.Ecommerce.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}
