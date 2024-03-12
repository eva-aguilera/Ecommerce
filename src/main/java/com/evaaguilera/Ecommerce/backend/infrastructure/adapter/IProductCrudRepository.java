package com.evaaguilera.Ecommerce.backend.infrastructure.adapter;

import com.evaaguilera.Ecommerce.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
