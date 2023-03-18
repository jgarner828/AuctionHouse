package com.garnerju.auctionhouse.models.socketmodels;

import com.garnerju.auctionhouse.models.auctionmodels.Bid;
import com.garnerju.auctionhouse.models.socketmodels.MessageType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SocketMessage {


    private MessageType type;

    private Bid newBid;

    private String sender;

    private String time;
}
