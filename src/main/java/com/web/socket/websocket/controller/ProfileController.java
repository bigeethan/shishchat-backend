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
    public List<Profile> getProfile(@PathVariable String username) {
        return profileRepository.findByUsername(username);
    }

    @PostMapping("/createprofile")
    public ResponseEntity<?> createProfile(@Valid @RequestBody Profile profile) {
        profileRepository.save(profile);

        return ResponseEntity.ok(new MessageResponse("Profile created successfully!"));
    }

    @PutMapping("/employees/{username}")
    public ResponseEntity<?> updateProfile(@PathVariable String username, @Valid @RequestBody Profile userProfile) {
        Profile profile = (Profile) profileRepository.findByUsername(username);

        profile.setBio(userProfile.getBio());
        profileRepository.save(profile);
        return ResponseEntity.ok(new MessageResponse("Profile created successfully!"));
    }
}
