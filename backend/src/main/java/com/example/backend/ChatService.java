package com.example.backend;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService extends TextWebSocketHandler {

    private final List<String> history = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("Bisherige Meldungen:" + history));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        history.add(payload);
        System.out.println(payload);
        session.sendMessage(new TextMessage("Danke für Deine Nachricht '" + payload + "' - bis zum nächsten Mal."));
    }
}
