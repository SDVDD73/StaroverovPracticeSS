package com.chat.simbir.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "room_user_role")
public class RoomUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
   // @Fetch(FetchMode.JOIN)
    @NonNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id")
    @NonNull
    private Roles role;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

    @Column
    @NonNull
    private boolean enable;
}
