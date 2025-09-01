package iuh.fit.se.bai6websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    // Lưu danh sách client đang kết nối
    private static final Set<Session> clients =
            Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        System.out.println("Client connected: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Received from " + session.getId() + ": " + message);

        // Gửi message cho tất cả client
        synchronized (clients) {
            for (Session s : clients) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendText("Client " + session.getId() + ": " + message);
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        System.out.println("Client disconnected: " + session.getId());
    }
}

