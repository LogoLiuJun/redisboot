package com.cssl.redis.entity;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users implements Serializable {
    private Integer id;
    private String name;
    private int age;
}
