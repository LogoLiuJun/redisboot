package com.cssl.redis.controller;

import com.cssl.redis.entity.Users;
import com.cssl.redis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UsersController {
    //业务逻辑层
    @Autowired
   private UsersService usersService;

    @GetMapping("/getUsers")
    @ResponseBody
    public Users getUsers(int id){
        System.out.println("UsersController_id:"+id);
      return  usersService.getUser(id);
    }
    @GetMapping("/allUsers")
    @ResponseBody
   public List<Users> allUsers(int id){
        System.out.println("userController:"+id);
        return usersService.allUsers(id);
    }

    @GetMapping("/allUsers2")
    @ResponseBody
    public List<Users> allUsers2(int id){
        System.out.println("userController2:"+id);
        return usersService.allUsers2(id);
    }
}
