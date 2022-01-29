package com.web.socket.websocket.Repositories;

import com.web.socket.websocket.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByUsername(String username);
}
