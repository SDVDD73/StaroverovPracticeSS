package com.chat.simbir.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NonNull
    private User userId;

    @NonNull
    @Column(length = 2048)
    private String text;

    //\\ @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Timestamp time;

    @NonNull
    private boolean enable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

}
