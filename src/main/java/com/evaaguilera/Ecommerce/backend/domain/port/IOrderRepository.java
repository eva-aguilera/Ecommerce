package com.evaaguilera.Ecommerce.backend.domain.port;

import com.evaaguilera.Ecommerce.backend.domain.model.Order;

public interface IOrderRepository {
    Order save (Order order);
    Order findById(Integer Id);
    Iterable<Order> findAll();
    Iterable<Order> findByUserId(Integer userId);
    void updateStateById(Integer id, String state);

}
