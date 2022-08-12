package com.garnerju.auctionhouse.web.controllers;

import com.garnerju.auctionhouse.web.models.MessageType;
import com.garnerju.auctionhouse.web.models.SocketMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;



@Component
public class WebSocketEventListener {

    private static final Log LOG = LogFactory.getLog(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations sendingOperations;



    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event)  {
        LOG.info("We have a new connection to " + event.getMessage());
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