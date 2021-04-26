package com.ecommerce.usermicroservice.service;

import com.ecommerce.usermicroservice.vo.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
