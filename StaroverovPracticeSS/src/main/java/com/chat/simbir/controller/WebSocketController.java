package com.chat.simbir.controller;

import com.chat.simbir.constant.Constants;
import com.chat.simbir.model.dto.ChatMessage;
import com.chat.simbir.model.entity.Message;
import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.entity.User;
import com.chat.simbir.service.MessageService;
import com.chat.simbir.service.RoomService;
import com.chat.simbir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;

import static java.lang.String.format;

/***
 *
 * Payload-annotated method arguments to extract the payload
 * of a Message and optionally convert it using a MessageConverter.
 * The presence of the annotation is not required since it is
 * assumed by default for method arguments that are not annotated.
 * Payload method arguments annotated with Validation annotations (like Validated) will be subject to JSR-303 validation.
 *
 *STOMP over WebSocket
 * An @SendTo annotation is not strictly required — by default the Message will be sent to
 * the same destination as the incoming Message but with an additional prefix ("/topic" by default).
 * It is also possible to use the SendToUser annotation to have the Message directed to a specific user if
 * connected. The return value is converted with a MessageConverter.
 *
 */

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {


        Message message = createMessage(roomId, chatMessage);

        messageService.seveMessage(message);

        messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
    }

    @MessageMapping("/chat/{roomId}/addUser")
    public void addUser(@DestinationVariable String roomId, @Payload ChatMessage chatMessage,
                        SimpMessageHeaderAccessor headerAccessor) {
        String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_id", roomId);
        if (currentRoomId != null) {
            ChatMessage leaveMessage = new ChatMessage();
            leaveMessage.setType(ChatMessage.MessageType.LEAVE);
            leaveMessage.setSender(chatMessage.getSender());
            messagingTemplate.convertAndSend(format("/channel/%s", currentRoomId), leaveMessage);
        }
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
    }

    private Message createMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {

        Room room = roomService.getByRoom((Long.valueOf(roomId)));
        User user = userService.getByUser(chatMessage.getSender());


        return new Message(user, room, chatMessage.getContent(),
                new Timestamp(System.currentTimeMillis()),true);
    }



}
