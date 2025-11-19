package com.mydevhub.crud.service;

import com.mydevhub.crud.entity.Profile;
import com.mydevhub.crud.entity.User;
import com.mydevhub.crud.repository.ProfileRepository;
import com.mydevhub.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    //create profile
    public Profile createProfile(Profile profile, Long userId){
        User user = userRepository.findById(userId) // cari user by id
                .orElseThrow(()->new RuntimeException("User not found"));
        //set user profile
        profile.setUser(user);

        return profileRepository.save(profile);
    }

    //get profile by id
    public Optional<Profile> getProfileByUserId (Long userId){
        return profileRepository.findByUserId(userId);
    }

    //update profile
    public Profile updateProfile(Long profileId, Profile profileDetails){
        Profile existingProfile = profileRepository.findById(profileId) // Cari profile by id
                .orElseThrow(()->new RuntimeException("Profile nOT Found"));
        //update new profile
        existingProfile.setBio(profileDetails.getBio());
        existingProfile.setGithubUrl(profileDetails.getGithubUrl());
        existingProfile.setLinkedinUrl(profileDetails.getLinkedinUrl());

        return profileRepository.save(existingProfile);
    }

    //delete profile
    public void deleteProfile(Long profileId){
        profileRepository.deleteById(profileId);

    }
}
