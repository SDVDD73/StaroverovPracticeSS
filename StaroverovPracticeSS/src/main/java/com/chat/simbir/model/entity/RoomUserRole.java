package com.chat.simbir.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "room_user_role")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @NonNull
    private Roles role;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

}
