package com.garnerju.auctionhouse.controllers;

import com.garnerju.auctionhouse.models.StompMessageBid;
import com.garnerju.auctionhouse.models.StompMessageBidReply;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BidController {


    @MessageMapping("/bid")
    @SendTo("/topic/bids")
    public StompMessageBidReply greeting(StompMessageBid message) throws Exception {

        return new StompMessageBidReply("Hello" + message.toString());
    }

}
