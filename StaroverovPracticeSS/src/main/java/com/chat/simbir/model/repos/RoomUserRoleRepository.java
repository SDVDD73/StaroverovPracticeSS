package com.chat.simbir.model.repos;

import com.chat.simbir.model.entity.Role;
import com.chat.simbir.model.entity.RoomUserRole;
import com.chat.simbir.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUserRoleRepository  extends JpaRepository<RoomUserRole, Long> {
}
