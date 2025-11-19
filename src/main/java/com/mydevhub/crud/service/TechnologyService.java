package com.mydevhub.crud.service;

import com.mydevhub.crud.entity.Technology;
import com.mydevhub.crud.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    //createTechnology
    public Technology createTechnology(Technology technology) {
        try {
            return technologyRepository.save(technology);
        } catch (DataIntegrityViolationException e) {
            // Handle error di sini. Boleh throw custom exception ke atau return null.
            // Contoh: throw new RuntimeException("Technology with this name already exists!");
            throw new RuntimeException("Technology with this name already exists!");
        }
    }

    //getAllTechnologies
    public List<Technology> getAllTechnologies(){
        return technologyRepository.findAll();
    }

    //getTechnologyById
    public Optional<Technology> getTechnologyById(Long id){
        return technologyRepository.findById(id);
    }

    //deleteTechnology
    public void deleteTechnology(Long id){
        technologyRepository.deleteById(id);
    }
}
