package com.alapanoski.chrpr.controller;

import com.alapanoski.chrpr.model.Chrp;
import com.alapanoski.chrpr.model.User;
import com.alapanoski.chrpr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{username}")
    public List<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/user/{username}/displayname")
    public String getUserDisplayNameByUsername(@PathVariable String username) {
        return userService.getUserDisplayNameByUsername(username);
    }

    @PostMapping("/user")
    public String addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/user/{username}/chrp")
    public List<Chrp> getChrpsByUser(@PathVariable String username) {
        return userService.getChrpsByUser(username);
    }
}
