package com.mydevhub.crud.controller;

import com.mydevhub.crud.entity.Profile;
import com.mydevhub.crud.service.ProfileService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<Profile> createProfile(
            @RequestBody Profile profile,
            @PathVariable Long userId){
        Profile createdProfile = profileService.createProfile(profile, userId);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Profile> getProfileByUserId (@PathVariable Long userId){
        return profileService.getProfileByUserId(userId)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<Profile> updateProfileById (@PathVariable Long profileId,
                                                      @RequestBody Profile profileDetails){
        try {
            Profile updatedProfile = profileService.updateProfile(profileId, profileDetails);
            return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Void> deleteProfile (@PathVariable Long profileId){
        profileService.deleteProfile(profileId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
