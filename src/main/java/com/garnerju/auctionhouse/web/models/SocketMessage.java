package com.garnerju.auctionhouse.web.models;

import lombok.Builder;
import lombok.Getter;

@Builder

public class SocketMessage {

    @Getter
    private MessageType type;

    @Getter
    private String content;

    @Getter
    private String sender;

    @Getter
    private String time;
}
