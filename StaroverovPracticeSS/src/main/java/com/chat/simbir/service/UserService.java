package com.chat.simbir.service;

import com.chat.simbir.model.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


    public com.chat.simbir.model.entity.User addUser(com.chat.simbir.model.entity.User user) {
        com.chat.simbir.model.entity.User saveUser = userRepository.save(user);
        return saveUser;
    }



    public void delete(long id) {
        userRepository.deleteById(id);
    }


    public com.chat.simbir.model.entity.User getByUser(String name) {
        return userRepository.findByUsername(name);
    }


    public com.chat.simbir.model.entity.User editUser(com.chat.simbir.model.entity.User user) {
        return userRepository.save(user);
    }



    public List<com.chat.simbir.model.entity.User> getAll() {
        return userRepository.findAll();
    }
}
