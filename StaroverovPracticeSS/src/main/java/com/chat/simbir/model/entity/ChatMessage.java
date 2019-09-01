package com.chat.simbir.model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    @NonNull
    private MessageType type;
    @NonNull
    private String content;
    @NonNull
    private String sender;

    @NonNull
    public enum MessageType{
        CHAT, JOIN, LEAVE
    }
};







