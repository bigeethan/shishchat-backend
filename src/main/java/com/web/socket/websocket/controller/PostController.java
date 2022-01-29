package com.web.socket.websocket.controller;

import com.web.socket.websocket.Repositories.PostRepository;
import com.web.socket.websocket.model.Post;
import com.web.socket.websocket.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/getposts")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/getposts/{user}")
    public Optional<Post> getPostsByUser(@PathVariable String user) {
        return postRepository.findByUsername(user);
    }

    @PostMapping("/createpost")
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post) {
        postRepository.save(post);

        return ResponseEntity.ok(new MessageResponse("Post created successfully!"));
    }
}
