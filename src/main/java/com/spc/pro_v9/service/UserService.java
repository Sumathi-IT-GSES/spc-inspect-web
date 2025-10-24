package com.spc.pro_v9.service;

import com.spc.pro_v9.entity.User;
import com.spc.pro_v9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public void addUser(User user){
//        userRepository.save(user);
//    }
//
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//
//    private final UserRepository userRepository = new UserRepository();

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        System.out.println("Pass values to userRepository from service--------");
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }


}
