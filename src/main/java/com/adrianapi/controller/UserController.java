package com.adrianapi.controller;

import com.adrianapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public User getUser(@PathVariable Integer id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public AddingResponse addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserFull(@RequestBody User user,
                                          @PathVariable("id") Integer id) throws UserNotFoundException {
        userService.updateUserFull(user);
        return ResponseEntity.ok(getUser(id));
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PATCH)
    public User updateUserPartial(@RequestBody User user,
                                            @PathVariable("id") Integer id) throws UserNotFoundException {
        return userService.updateUserPartial(user, id);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public DeletingResponse deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        return userService.deleteUser(id);
    }
}
