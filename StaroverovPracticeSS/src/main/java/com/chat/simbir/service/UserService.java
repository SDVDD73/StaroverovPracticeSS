package com.chat.simbir.service;

import com.chat.simbir.model.entity.User;
import com.chat.simbir.model.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


    public User addUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User getByUser(String name) {
        return userRepository.findByUsername(name);
    }

    @Transactional
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Transactional
    public List<String> getRolesOfUserFromRoom(Long roomId, Long userId){
        return userRepository.roleFromRoom(roomId, userId);
    }
}
