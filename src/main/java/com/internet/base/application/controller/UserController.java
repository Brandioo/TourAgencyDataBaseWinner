package com.internet.base.application.controller;

import com.internet.base.application.model.Client;
import com.internet.base.application.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public Client addUser(@RequestBody Client users) {
        return userService.addUser(users);

    }

//    @PostMapping
//    public int save(@RequestBody @Valid SaveUsersRequest request) {
//        return userService.save(request);
//    }

    @GetMapping("/users")
    public List<Client> getUsers() {
        return userService.getUsers();

    }

    @GetMapping("/users/{usersId}")
    public ResponseEntity<?> getTechById(@PathVariable Long usersId) {
        return userService.getUserById(usersId);

    }

    @PutMapping("/users/{usersId}")
    public ResponseEntity<?> updateUser(@PathVariable Long usersId, @Valid @RequestBody Client userRequest) {

        return userService.updateUser(usersId, userRequest);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {

        return userService.deleteUser(userId);

    }

}
