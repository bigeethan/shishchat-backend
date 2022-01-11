package com.web.socket.websocket.controller;

import com.web.socket.websocket.Repositories.PostRepository;
import com.web.socket.websocket.model.Post;
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
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/getposts")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @PostMapping(name = "/createpost")
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post) {
        postRepository.save(post);

        return ResponseEntity.ok(new MessageResponse("Post created successfully!"));
    }
}
