package com.chat.simbir.controller;

import com.chat.simbir.model.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

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


}
