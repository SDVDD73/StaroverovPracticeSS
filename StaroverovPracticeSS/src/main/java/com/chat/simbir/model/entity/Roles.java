package com.chat.simbir.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    @NonNull
    private Role role;

}