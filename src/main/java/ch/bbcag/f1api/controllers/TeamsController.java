package ch.bbcag.f1api.controllers;

import ch.bbcag.f1api.models.Teams;
import ch.bbcag.f1api.repositories.TeamsRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/teams")
public class TeamsController {
    @Autowired
    private TeamsRepository teamsRepository;

    @GetMapping()
    public Iterable<Teams> findByName(@RequestParam(required = false) String name){
        if(Strings.isNotBlank(name)){
            return teamsRepository.findByName(name);
        }
        return teamsRepository.findAll();
    }
}
