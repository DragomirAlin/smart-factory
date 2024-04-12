package ro.dragomiralin.gateway.websocket.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ro.dragomiralin.gateway.common.Data;
import ro.dragomiralin.gateway.websocket.WebSocketService;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService {
    private final SimpMessagingTemplate template;

    @Override
    public void emit(Data data) {
        this.template.convertAndSend("/message",  data);
    }
}
