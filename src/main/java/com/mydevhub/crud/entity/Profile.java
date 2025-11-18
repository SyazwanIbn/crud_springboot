package com.mydevhub.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String bio;

    private String linkedinUrl;
    private String githubUrl;

    //RELATIONSHIP ENTTIY

    //Profile ni User punya.So Profile yang akan ada foreign key kepada User
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id") // create column 'user_id' yang refer 'id' kat table User
    @JsonIgnore // untuk elak infinite looping bila convert ke JSON,elak stackOverflowError
    private User user;

}
