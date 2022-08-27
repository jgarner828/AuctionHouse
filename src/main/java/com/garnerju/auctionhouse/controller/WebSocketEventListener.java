package com.garnerju.auctionhouse.controller;

import com.garnerju.auctionhouse.models.MessageType;
import com.garnerju.auctionhouse.models.SocketMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


@Component
public class WebSocketEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations sendingOperations;



    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event)  {
        LOG.info("We have a new connection to:  " + event.getMessage());
    }

    @EventListener
    public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event)  {
        final StompHeaderAccessor   headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        final String username = (String) headerAccessor.getSessionAttributes().get("username");
        final SocketMessage socketMessage = SocketMessage.builder()
                .type(MessageType.DISCONNECT)
                .sender(username)
                .build();

        sendingOperations.convertAndSend("/topic/public", socketMessage);
    }

}
