package com.chat.simbir.model.repos;


import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.entity.RoomUserRole;
import com.chat.simbir.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("select rur.role.role from User u " +
            "join u.roomUserRoles rur on rur.user.id = u.id " +
            "where rur.room.id = ?1 and u.id = ?2")
    List<String> roleFromRoom(long roomId, long userId);


    @Query("select distinct rur.room from User u " +
            "join u.roomUserRoles rur on rur.user.id = u.id " +
            "where rur.enable = true and u.id = ?1")
    List<Room> getSubscriptionsRoomsofUsers(long userId);

    List<User> findByEnable(Boolean aBoolean);
}



/*"select roles.role_name " +
            "from User " +
            "join room_user_role rur ON rur.user_id = User.id " +
            "join roles ON roles.id = rur.role_id " +
            "where rur.room_id = 1 and User.id = 1")
            */