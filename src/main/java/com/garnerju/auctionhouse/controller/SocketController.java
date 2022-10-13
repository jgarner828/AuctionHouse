package com.garnerju.auctionhouse.controller;


import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.models.auctionmodels.Bid;
import com.garnerju.auctionhouse.models.socketmodels.MessageType;
import com.garnerju.auctionhouse.models.socketmodels.SocketMessage;

import com.garnerju.auctionhouse.repository.BidRepository;
import com.garnerju.auctionhouse.service.AuctionItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Log4j2
@Controller
public class SocketController {

    @Autowired
    private AuctionItemService service;

    @MessageMapping("/socket.send")
    @SendTo("/topic/bids")
    public AuctionItems sendMessage(@Payload final SocketMessage message) throws Exception {
        try
        {
            if (message.getType() == MessageType.BID)
            {
               service.newBid(message);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException("Failed to parse bid: " + message);
        }
            return null;
    }



    @MessageMapping("/socket.newUser")
    @SendTo("/topic/users")
    public SocketMessage newUser(@Payload final SocketMessage message,
                                 SimpMessageHeaderAccessor  headerAccessor) {
        System.out.println(message);
        headerAccessor.getSessionAttributes().put("username", message.getSender());
    return message;
    }

}
