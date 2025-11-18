package com.mydevhub.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    private String githubRepoUrl;

    //RELATIONSHIP ENTITY

    //BANYAK PROJEK UNTUK SATU USER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // wajib ada user id
    @JsonIgnore
    private User user;

    //SATU PROJEK BANYAK TECHNOLOGY
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //save/update Project, dia akan auto save/update Technology yang baru kalau ada.
    @JoinTable( //create join table yang gabungkan Project dan Technology
            name = "project_technologies", //nama join table
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
            private List<Technology> technologies;

}
