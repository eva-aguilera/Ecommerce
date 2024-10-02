package com.evaaguilera.Ecommerce.backend.infrastructure.rest;

import com.evaaguilera.Ecommerce.backend.aplication.UserService;
import com.evaaguilera.Ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;

@RestController
//http://localhost:8085
@RequestMapping("/api/v1/users")
//http://localhost:8085/api/v1/users
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
@PostMapping
    public User save(@RequestBody User user){
      return userService.save(user);
    }


    @GetMapping("/{id}")
    public  User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
