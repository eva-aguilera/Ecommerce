package com.evaaguilera.Ecommerce.backend.domain.port;

import com.evaaguilera.Ecommerce.backend.domain.model.Product;

public interface IProductRepository {
    Product save (Product product);
    Iterable<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);
}