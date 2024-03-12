package com.evaaguilera.Ecommerce.backend.domain.port;

import com.evaaguilera.Ecommerce.backend.domain.model.User;

public interface IUserRepository {
    User save(User user);
    User findByEmail(String email);
    User findById(Integer id);
}
