package com.mydevhub.crud.controller;

import com.mydevhub.crud.entity.Project;
import com.mydevhub.crud.service.ProjectService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // CREATE
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectPayload payload) {
        // 1. Cipta Project object dari data payload
        Project project = new Project();
        project.setTitle(payload.getTitle());
        project.setDescription(payload.getDescription());
        project.setGithubRepoUrl(payload.getGithubRepoUrl());

        // 2. Panggil service dengan data yang lengkap
        Project createdProject = projectService.createProject(project, payload.getUserId(), payload.getTechnologyIds());

        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        // Gunakan pattern if-else yang kau suka
       if(project.isPresent()){
            return new ResponseEntity<>(project.get(), HttpStatus.OK);
       }else{
           return new ResponseEntity<>("Project Not Found", HttpStatus.NOT_FOUND);
       }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

@Data
class ProjectPayload {
    private String title;
    private String description;
    private String githubRepoUrl;
    private Long userId;               // ID untuk owner
    private List<Long> technologyIds;   // Senarai ID untuk teknologi

    // Kena ada getter dan setter
    // Guna Lombok: @Data @NoArgsConstructor @AllArgsConstructor
}
