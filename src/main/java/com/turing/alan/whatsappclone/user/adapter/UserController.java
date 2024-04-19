package com.turing.alan.whatsappclone.user.adapter;

import org.springframework.web.bind.annotation.RestController;

import com.turing.alan.whatsappclone.user.domain.UserEntity;
import com.turing.alan.whatsappclone.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Iterable<UserEntity> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserEntity getMethodName(@PathVariable(name = "id") long id) {
        return userService.getOne(id);
    }
    

    @PostMapping("/user")
    public UserEntity createUser(@RequestBody UserEntity newUser) {
        return this.userService.create(newUser); 
    }
    
    
}
