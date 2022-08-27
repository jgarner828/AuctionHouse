package com.garnerju.auctionhouse.controller;


import com.garnerju.auctionhouse.models.SocketMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Controller
public class SocketController {


    @MessageMapping("/socket.send")
    @SendTo("/topic/public")
    public SocketMessage sendMessage(@Payload final SocketMessage message) {
        System.out.println(message.getContent());
        return message;
    }

    @MessageMapping("/socket.newUser")
    @SendTo("/topic/public")
    public SocketMessage newUser(@Payload final SocketMessage message,
                                 SimpMessageHeaderAccessor  headerAccessor) {
        System.out.println(message.getContent());

        headerAccessor.getSessionAttributes().put("username", message.getSender());
    return message;
    }

}
