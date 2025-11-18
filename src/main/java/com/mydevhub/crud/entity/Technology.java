package com.mydevhub.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    //RELATIONSHIP ENTITY

    //Satu technology untuk banyak project
    @ManyToMany(mappedBy = "technologies")
    private List<Project> projects;
}
