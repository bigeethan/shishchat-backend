package com.web.socket.websocket.controller;

import com.web.socket.websocket.Repositories.ProfileRepository;
import com.web.socket.websocket.model.Profile;
import com.web.socket.websocket.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("/getprofile/{username}")
    public Optional<Profile> getProfile(@PathVariable String username) {
        return profileRepository.findByUsername(username);
    }

    @PostMapping("/createprofile")
    public ResponseEntity<?> createProfile(@Valid @RequestBody Profile profile) {
        profileRepository.save(profile);

        return ResponseEntity.ok(new MessageResponse("Profile created successfully!"));
    }
}
