package com.chat.simbir.model.repos;

import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.entity.RoomUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findById(long idRoom);
}
