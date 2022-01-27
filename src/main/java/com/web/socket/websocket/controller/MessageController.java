package com.web.socket.websocket.controller;

import com.web.socket.websocket.Repositories.MessageRepository;
import com.web.socket.websocket.model.Message;
import com.web.socket.websocket.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/getmessages")
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @PostMapping("/addmessage")
    public ResponseEntity<?> addMessage(@Valid @RequestBody Message message) {
        messageRepository.save(message);

        return ResponseEntity.ok(new MessageResponse("Message added successfully!"));
    }
}
