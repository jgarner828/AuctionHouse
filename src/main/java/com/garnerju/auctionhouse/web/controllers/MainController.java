package com.garnerju.auctionhouse.web.controllers;


import com.garnerju.auctionhouse.web.models.SocketMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @MessageMapping("/socket.send")
    @SendTo("/topic/public")
    public SocketMessage sendMessage(@Payload final SocketMessage message) {
        return message;
    }

    @MessageMapping("/socket.newUser")
    @SendTo("/topic/public")
    public SocketMessage newUser(@Payload final SocketMessage message,
                                 SimpMessageHeaderAccessor  headerAccessor) {

        headerAccessor.getSessionAttributes().put("username", message.getSender());
    return message;
    }

}
