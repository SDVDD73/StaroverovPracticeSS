package com.chat.simbir.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    @NonNull
    private Role role;

    @OneToMany(targetEntity = RoomUserRole.class, mappedBy = "role", orphanRemoval = false, fetch = FetchType.LAZY)
    protected Set<RoomUserRole> roomUserRoles;


}