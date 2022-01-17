package ch.bbcag.f1api.controllers;


import ch.bbcag.f1api.models.Drivers;
import ch.bbcag.f1api.repositories.DriversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/drivers")
public class DriversController {

    @Autowired
    private DriversRepository driversRepository;

    @GetMapping("{id}")
    public Iterable<Drivers> findById(@PathVariable int id){
        try {
            return driversRepository.findByDriverId(id);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
