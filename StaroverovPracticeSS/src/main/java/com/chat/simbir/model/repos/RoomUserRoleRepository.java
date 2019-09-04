package com.chat.simbir.model.repos;

import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.entity.RoomUserRole;
import com.chat.simbir.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomUserRoleRepository  extends JpaRepository<RoomUserRole, Long> {

    List<RoomUserRole> findById(long idRoomUserRole);

    @Query("select rur.role.id from RoomUserRole rur " +
            "where rur.user.id = ?1 and rur.room.id = ?2 and rur.enable = true")
    List<Long> isUserofRoom(long idUser, long idRoom);

}
