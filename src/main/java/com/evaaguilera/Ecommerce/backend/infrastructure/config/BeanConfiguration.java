package com.evaaguilera.Ecommerce.backend.infrastructure.config;

import com.evaaguilera.Ecommerce.backend.aplication.CategoryService;
import com.evaaguilera.Ecommerce.backend.aplication.OrderService;
import com.evaaguilera.Ecommerce.backend.aplication.ProductService;
import com.evaaguilera.Ecommerce.backend.aplication.UserService;
import com.evaaguilera.Ecommerce.backend.domain.port.ICategoryRepository;
import com.evaaguilera.Ecommerce.backend.domain.port.IOrderRepository;
import com.evaaguilera.Ecommerce.backend.domain.port.IProductRepository;
import com.evaaguilera.Ecommerce.backend.domain.port.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository){
        return new CategoryService(iCategoryRepository);
    }

    @Bean
public ProductService productService(IProductRepository iProductRepository){
        return new ProductService(iProductRepository);
    }
    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);
    }

}
