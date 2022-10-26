package com.usal.demo.service;

import com.usal.demo.model.User;
import com.usal.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.insert(user);
    }

    public void addList(List<User> userList){
        userRepository.saveAll(userList);
    }

    public User addUserWithSave(User user){
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        User savedUser = userRepository.findById(user.getId())
                .orElseThrow(() ->
                        new RuntimeException(
                                String.format("Unable to find User ID" +
                                                "%S",
                                        user.getId())
                        ));

        savedUser.setAge(user.getAge());
        savedUser.setName(user.getName());
        savedUser.setYearOfBirth(user.getYearOfBirth());
        savedUser.setContact(user.getContact());

        userRepository.save(user);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(User user) {
        return userRepository.findById(user.getId())
                .orElseThrow(() ->
                        new RuntimeException(
                                String.format("Unable to find User ID" +
                                                "%S",
                                        user.getId())
                        ));
    }


}
