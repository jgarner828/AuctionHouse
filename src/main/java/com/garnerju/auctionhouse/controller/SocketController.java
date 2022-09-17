package com.garnerju.auctionhouse.controller;


import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.models.socketmodels.SocketMessage;

import com.garnerju.auctionhouse.service.AuctionItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Log4j2
@Controller
public class SocketController {
//    private static final Logger LOG = LoggerFactory.getLogger(SocketController.class);

    private AuctionItemService service;

    @MessageMapping("/socket.send")
    @SendTo("/topic/public")
    public List<AuctionItems> sendMessage(@Payload final SocketMessage message) {
        System.out.println(message);
        List<AuctionItems> result = service.getAuctionItems();

        System.out.println("result " + result);
        return result;
    }

//    @MessageMapping("/socket.newUser")
//    @SendTo("/topic/public")
//    public SocketMessage newUser(@Payload final SocketMessage message,
//                                 SimpMessageHeaderAccessor  headerAccessor) {
//        System.out.println(message.getContent());
//
//        headerAccessor.getSessionAttributes().put("username", message.getSender());
//    return message;
//    }

}
