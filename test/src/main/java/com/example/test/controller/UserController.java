package com.example.test.controller;

import com.example.test.dto.UserResponse;
import com.example.test.entity.User;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void add(){
        userService.add();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void test() {
        userService.getOne(2L);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> test2() {
        return userService.getAll();
    }

}
