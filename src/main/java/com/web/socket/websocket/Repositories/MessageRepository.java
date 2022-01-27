package com.web.socket.websocket.Repositories;

import com.web.socket.websocket.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
