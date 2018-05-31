package com.adrianapi.controller;

import com.adrianapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    List<User> users = new ArrayList<>(Arrays.asList(
//            new User("Mike", "aPassword", "anEmailAddress"),
//                new User("Liam", "password", "email"),
//                new User("Paty", "pass123", "anEmail@Address.com")
//    ));


    public List<User> getAllUsers() {
        // return users;
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public Optional<User> getUser(Integer id) {
        // return users.stream()
        //        .filter(u -> u.getName().equalsIgnoreCase(name))
        //        .findFirst()
        //        .get();
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        // users.add(user);
        userRepository.save(user);
    }


    public void updateUser(Integer id, User user) {
//        User userHolder;
//        for (int i = 0; i < users.size(); i++) {
//             userHolder = users.get(i);
//            if(userHolder.getName().equalsIgnoreCase(name)) {
//                users.set(i, user);
//            }
//        }
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {

        // users.removeIf(u -> u.getName().equalsIgnoreCase(name));
        userRepository.deleteById(id);
    }
}
