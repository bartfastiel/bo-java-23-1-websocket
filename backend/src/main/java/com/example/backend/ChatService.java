package com.example.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService extends TextWebSocketHandler {

    private final List<String> history = new ArrayList<>();

    private final ObjectMapper objectMapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        String json = objectMapper.writeValueAsString(history);

        session.sendMessage(new TextMessage(json));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        history.add(payload);
        System.out.println(payload);
        session.sendMessage(new TextMessage("Danke für Deine Nachricht '" + payload + "' - bis zum nächsten Mal."));
    }
}
