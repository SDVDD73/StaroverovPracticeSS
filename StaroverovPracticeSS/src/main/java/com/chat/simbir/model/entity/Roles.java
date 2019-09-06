package com.chat.simbir.model.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Roles {

    public Roles(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "role_name", unique = true)
    @Enumerated(EnumType.STRING)
    @NonNull
    private Role role;

    @OneToMany(targetEntity = RoomUserRole.class, mappedBy = "role", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Set<RoomUserRole> roomUserRoles;


}