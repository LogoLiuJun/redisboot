package com.cssl.redis.service.impl;

import com.cssl.redis.dao.UsersDao;
import com.cssl.redis.entity.Users;
import com.cssl.redis.service.UsersService;
import com.cssl.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceimpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    //@CachePut(value = "user",key = "#id", condition="#id%2==1")
    @Cacheable(value = "user",key = "#id", condition="#id%2==1")
    public Users getUser(int id) {
        System.out.println("UsersService_id:"+id);
        return  usersDao.getUser(id);
    }

    @Override
    @Cacheable(value="ww", key="#id")   //Cacheable缓存：第一次会走service,后面直接从缓存中拿
    public List<Users> allUsers(int id) {
        System.out.println("UsersService_allUsers");
        return usersDao.allUsers();
    }

    @Override
    public List<Users> allUsers2(int id) {
        System.out.println("UsersService_allUsers2");
        List<Users>ls=null;
        if(redisUtil.exists("ls")){
            System.out.println("exists**************************:");
            ls=(List<Users>)redisUtil.get("ls");
            for (Users n : ls) {
                System.out.println("s:list:"+n);
            }
        }else {
            System.out.println("not exists**********************:");
            //从数据库取并保存到redis
            ls = usersDao.allUsers2();
            redisUtil.set("ls",ls,50L);
        }
        return ls;
    }
}
