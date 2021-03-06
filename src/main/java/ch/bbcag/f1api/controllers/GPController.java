package ch.bbcag.f1api.controllers;

import ch.bbcag.f1api.models.GP;
import ch.bbcag.f1api.repositories.GPRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/gp")
public class GPController {

    @Autowired
    private GPRepository gpRepository;

    @GetMapping()
    public Iterable<GP> findByParam(@RequestParam(required = false) String name, @RequestParam(required = false) Integer year) {
        try {
            if (Strings.isNotBlank(name) && year != null) {
                return gpRepository.findByYearAndLastName(name, year);
            } else if (Strings.isNotBlank(name)) {
                return gpRepository.findByWinnerLastName(name);
            } else if (Strings.isBlank(name) && year != null) {
                return gpRepository.findByYear(year);
            } else {
                return gpRepository.findAll();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public Iterable<GP> findById(@PathVariable int id) {
        return gpRepository.findById(id);
    }


    @PostMapping()
    public void insert(@RequestBody @Valid GP gp){
        gpRepository.save(gp);
    }

    @PutMapping
    public void update(@RequestBody @Valid GP gp){
        gpRepository.save(gp);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        try {
            gpRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //@GetMapping()
    //public Iterable<GP> findByYear(@RequestParam(required = false) int year){
    //    try {
    //        return gpRepository.findByYear(year);
    //    }catch (Exception e) {
    //        return gpRepository.findAll();
    //    }
    //}
}


