package com.evaaguilera.Ecommerce.backend.infrastructure.adapter;

import com.evaaguilera.Ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity,Integer> {
}
