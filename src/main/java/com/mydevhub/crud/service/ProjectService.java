package com.mydevhub.crud.service;

import com.mydevhub.crud.entity.Project;
import com.mydevhub.crud.entity.Technology;
import com.mydevhub.crud.entity.User;
import com.mydevhub.crud.repository.ProjectRepository;
import com.mydevhub.crud.repository.TechnologyRepository;
import com.mydevhub.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechnologyRepository technologyRepository;



    //create project
    public Project createProject(Project project, Long userId, List<Long> technologyIds){
        //1. cari user yang akan jadi owner
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id" + userId));


        //2. list semua technologies
        List<Technology> technologies = technologyRepository.findAllById(technologyIds);

        //2.1 Optional check if all technologies were found
        if(technologies.size() != technologyIds.size()){
            throw new RuntimeException("One or more technologies were not found");
        }

        //3. Connect user dan technologies dalam project
        project.setUser(user);
        project.setTechnologies(technologies);

        //4. return and save project
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
