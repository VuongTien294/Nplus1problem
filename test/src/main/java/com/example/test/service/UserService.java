package com.example.test.service;

import com.example.test.dto.UserResponse;
import com.example.test.entity.User;

import java.util.List;

public interface UserService {
     void getOne (Long id);

     List<UserResponse> getAll();

     void add();
}
