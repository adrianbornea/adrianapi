package com.adrianapi.controller;

import com.adrianapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> readUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
