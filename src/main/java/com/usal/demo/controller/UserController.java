package com.usal.demo.controller;

import com.usal.demo.model.User;
import com.usal.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/list")
    public ResponseEntity addUser(@RequestBody List<User> userlist){
        userService.addList(userlist);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUserWithSave(user));
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestBody User user){
        return ResponseEntity.ok(userService.getUser(user));
    }
}
