package com.chat.simbir.model.repos;

import com.chat.simbir.model.entity.Role;
import com.chat.simbir.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {

    @Query("select r from Roles r " +
            "where r.role = ?1")
    Roles findByRole (Role roles);


}

