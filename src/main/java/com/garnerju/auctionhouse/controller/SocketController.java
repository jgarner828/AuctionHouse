package com.garnerju.auctionhouse.controller;


import com.garnerju.auctionhouse.models.socketmodels.MessageType;
import com.garnerju.auctionhouse.models.socketmodels.SocketMessage;
import com.garnerju.auctionhouse.service.AuctionItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class SocketController {

    private AuctionItemService service;

    public SocketController(AuctionItemService service) {
        this.service = service;
    }

    @MessageMapping("/socket.send")
    @SendTo("/topic/bids")
    public SocketMessage sendMessage(@Payload final SocketMessage message) throws Exception {
        try
        {
            if (message.getType() == MessageType.BID)
            {
               service.newBid(message);
               return message;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException("Failed to parse bid: " + message);
        }

    return message;
    }


}
