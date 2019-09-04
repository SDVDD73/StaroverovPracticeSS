package com.chat.simbir.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)//, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)//, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

    @NonNull
    @Column(length = 2048)
    private String text;

    //\\ @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Timestamp time;

    @NonNull
    private boolean enable;
}


