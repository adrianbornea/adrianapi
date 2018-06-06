package com.adrianapi.controller;

import com.adrianapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class UserService {

    @Autowired
    private UserRepository userRepository;


    List<User> getAllUsers() {
        // return users
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        if (users.isEmpty()) {
            throw new EmptyDatabaseException("No users in the database");
        }
        return users;
    }

    User getUser(Integer id) throws UserNotFoundException {
        User user;
        if(userRepository.findById(id).isPresent()) {
            user = userRepository.findById(id).get();
            return user;
        } else {
            throw new UserNotFoundException("User not found. Id: " + id);
        }
    }

    AddingResponse addUser(User user) {
        try {
            userRepository.save(user);
            return new AddingResponse(user.getId());
        } catch (DataIntegrityViolationException ex) {
            throw new UserDataException("User not added to the database.");
        }
    }


    DeletingResponse deleteUser(Integer id) throws UserNotFoundException {
        try {
            userRepository.deleteById(id);
            return new DeletingResponse(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException("User to be deleted doesn't exist. Id: " + id);
        }
    }

    void updateUserFull(User user) {
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new UserDataException("User not updated.");
        }
    }

    User updateUserPartial(User user, Integer id) throws UserNotFoundException {
        User userToBeUpdated = getUser(id);
        if (user.getName() != null) {
            userToBeUpdated.setName(user.getName());
        }
        if (user.getPassword() != null) {
            userToBeUpdated.setPassword(user.getPassword());
        }
        if (user.getEmail() != null) {
            userToBeUpdated.setEmail(user.getEmail());
        }
        userRepository.save(userToBeUpdated);
        return userToBeUpdated;
    }
}
