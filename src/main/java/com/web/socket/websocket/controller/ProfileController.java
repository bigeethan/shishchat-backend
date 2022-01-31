package com.web.socket.websocket.controller;

import com.web.socket.websocket.Repositories.ProfileRepository;
import com.web.socket.websocket.model.Profile;
import com.web.socket.websocket.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("/getprofile/{username}")
    public Profile getProfile(@PathVariable String username) {
        return profileRepository.findByUsername(username);
    }

    @PostMapping("/createprofile/{username}")
    public ResponseEntity<?> createProfile(@PathVariable String username, @Valid @RequestBody Profile profile) {
        if (profileRepository.existsByUsername(username) == true) {
            return ResponseEntity.ok(new MessageResponse("Profile already exists"));
        } else {
            profileRepository.save(profile);

            return ResponseEntity.ok(new MessageResponse("Profile created successfully!"));
        }
    }

    @PutMapping("/editprofile/{username}")
    public ResponseEntity<?> updateProfile(@PathVariable String username, @Valid @RequestBody Profile userProfile) {
        Profile profile = profileRepository.findByUsername(username);

        profile.setBio(userProfile.getBio());
        profileRepository.save(profile);
        return ResponseEntity.ok(new MessageResponse("Profile created successfully!"));
    }
}
