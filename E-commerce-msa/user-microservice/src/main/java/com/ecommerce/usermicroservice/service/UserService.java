package com.ecommerce.usermicroservice.service;

import com.ecommerce.usermicroservice.jpa.UserEntity;
import com.ecommerce.usermicroservice.vo.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserAll();
}
