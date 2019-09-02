package com.chat.simbir.model.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
   // @Fetch(FetchMode.JOIN)
    @NonNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "role_id")
    @NonNull
    private Roles role;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

    @NonNull
    private boolean enable;

}
