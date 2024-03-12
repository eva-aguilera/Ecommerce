package com.evaaguilera.Ecommerce.backend.aplication;

import com.evaaguilera.Ecommerce.backend.domain.model.User;
import com.evaaguilera.Ecommerce.backend.domain.port.IUserRepository;

public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    public User save(User user){
        return iUserRepository.save(user);
    }
    public User findById (Integer id){
        return iUserRepository.findById(id);
    }
}
