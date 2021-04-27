package com.ecommerce.usermicroservice.service;

import com.ecommerce.usermicroservice.jpa.UserEntity;
import com.ecommerce.usermicroservice.vo.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserAll();

}
