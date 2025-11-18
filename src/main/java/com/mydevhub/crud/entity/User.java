package com.mydevhub.crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@Table(name = "users") // bagi table nama "users"
@NoArgsConstructor // auto generate empty constructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    //RELATIONSHIP ENTITY

    //SATU USER ADA BANYAK PROJECT
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // fetch = FetchType.LAZY, Data tak akan di-load dari database unless kita suruh. Bagus untuk performance.
    private List<Project> projects;

    //SATU USER ADA SATU PROFILE
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;


}


