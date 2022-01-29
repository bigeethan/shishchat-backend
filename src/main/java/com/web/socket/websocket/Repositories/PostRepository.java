package com.web.socket.websocket.Repositories;

import com.web.socket.websocket.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUser(String user);
}
