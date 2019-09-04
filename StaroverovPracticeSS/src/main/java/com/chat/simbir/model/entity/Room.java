package com.chat.simbir.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "room_name")
    @NonNull
    private String roomName;

    @NonNull
    private boolean enable;

    @OneToMany(targetEntity = Message.class, mappedBy = "room", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Message> messages;

    @OneToMany(targetEntity = RoomUserRole.class, mappedBy = "room", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<RoomUserRole> roomUserRoles;

}

