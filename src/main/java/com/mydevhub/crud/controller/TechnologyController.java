package com.mydevhub.crud.controller;

import com.mydevhub.crud.entity.Technology;
import com.mydevhub.crud.service.TechnologyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    //CREATE TECHNOLOGY
    @PostMapping()
    public ResponseEntity<?> createTechnology(@RequestBody Technology technology) {
        try {
            Technology createdTech = technologyService.createTechnology(technology);
            return new ResponseEntity<>(createdTech, HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT); //kalau nama dah ada, return error message
        }
    }

    //GET ALL TECHNOLOGY
    @GetMapping
    public ResponseEntity<List<Technology>> getAllTechnologies (){
        List<Technology> technologies = technologyService.getAllTechnologies();
        return new ResponseEntity<>(technologies, HttpStatus.OK);
    }

    //GET TECHNOLOGY BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getTechnologyById(@PathVariable Long id){
        Optional<Technology> technology = technologyService.getTechnologyById(id);

        if(technology.isPresent()){
            return new ResponseEntity<>(technology.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Technology not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTecnology (@PathVariable Long id){
        technologyService.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
