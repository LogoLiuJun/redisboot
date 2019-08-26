package com.cssl.redis.service;

import com.cssl.redis.entity.Users;

import java.util.List;

public interface UsersService {
    public Users getUser(int id);

    public List<Users> allUsers(int id);

    public List<Users> allUsers2(int id);
}
