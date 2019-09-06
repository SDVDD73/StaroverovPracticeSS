package com.chat.simbir.service;

import com.chat.simbir.model.entity.Role;
import com.chat.simbir.model.entity.Roles;
import com.chat.simbir.model.repos.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public Roles findByRole(Role role){
       return rolesRepository.findByRole(role);
    }
}
