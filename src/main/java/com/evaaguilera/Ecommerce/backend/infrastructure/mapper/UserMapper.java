package com.evaaguilera.Ecommerce.backend.infrastructure.mapper;

import com.evaaguilera.Ecommerce.backend.domain.model.User;
import com.evaaguilera.Ecommerce.backend.infrastructure.entity.UserEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
@Mappings(
        {
                @Mapping(source = "id", target="id"),
                @Mapping(source = "username", target = "username"),
                @Mapping(source = "lastName", target = "lastName"),
                @Mapping(source = "email", target = "email"),
                @Mapping(source = "address", target = "address"),
                @Mapping(source = "cellphone", target = "cellphone"),
                @Mapping(source = "password", target = "password"),
                @Mapping(source = "userType", target = "userType"),
                @Mapping(source = "dateCreated", target = "dateCreated"),
                @Mapping(source = "dateUpdated", target = "dateUpdated"),
        }
)
    User toUser(UserEntity userEntity);
Iterable<User> toUsers(Iterable<UserEntity> userEntities);
@InheritConfiguration
UserEntity toUserEntity(User user);
}
