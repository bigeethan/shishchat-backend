package com.web.socket.websocket.Repositories;

import com.web.socket.websocket.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
