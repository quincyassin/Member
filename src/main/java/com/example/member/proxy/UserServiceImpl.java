package com.example.member.proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void setName(String name) {
        System.out.println(name);
    }
}
