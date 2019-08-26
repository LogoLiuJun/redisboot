package com.cssl.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.cssl.redis.dao")
@EnableCaching
@EnableTransactionManagement
public class RedisbootApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(RedisbootApplication.class, args);
    }

}
