package com.cssl.redis.dao;

import com.cssl.redis.entity.Users;

import java.util.List;

public interface UsersDao {
    public Users getUser(int id);

    public List<Users> allUsers();

    public List<Users> allUsers2();
}
