package com.evaaguilera.Ecommerce.backend.infrastructure.adapter;

import com.evaaguilera.Ecommerce.backend.domain.model.User;
import com.evaaguilera.Ecommerce.backend.domain.port.IUserRepository;
import com.evaaguilera.Ecommerce.backend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {
private final IUserCrudRepository iUserCrudRepository;
private final UserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }


    @Override
    public User save(User user) {
        return userMapper.toUser( iUserCrudRepository.save( userMapper.toUserEntity(user) ));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toUser(iUserCrudRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email:" +email+ " not found")
        ));
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(iUserCrudRepository.findById(id).get());
    }
}
