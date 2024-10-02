package com.evaaguilera.Ecommerce.backend.aplication;

import com.evaaguilera.Ecommerce.backend.domain.model.User;
import com.evaaguilera.Ecommerce.backend.domain.port.IUserRepository;

public class RegistrationService {
    private final IUserRepository  iUserRepository;

    public RegistrationService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
     public User register (User user){
        return iUserRepository.save(user);
     }
}
