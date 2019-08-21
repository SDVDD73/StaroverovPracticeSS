package com.chat.simbir.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String text;

    private Timestamp time;

    private boolean enable;

    @Column(name = "room_id")
    private Integer roomId;

    public Message(){}
}
