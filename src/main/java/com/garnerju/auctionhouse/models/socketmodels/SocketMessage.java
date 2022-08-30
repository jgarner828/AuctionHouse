package com.garnerju.auctionhouse.models.socketmodels;

import com.garnerju.auctionhouse.models.socketmodels.MessageType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
