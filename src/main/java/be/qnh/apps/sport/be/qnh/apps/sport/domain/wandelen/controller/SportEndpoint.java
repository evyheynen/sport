package be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.controller;

import be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.service.Wandeling;
import be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.service.WandelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wandelingen")
public class SportEndpoint {

    @Autowired
    private WandelingService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Wandeling>> getAll() {

        Iterable<Wandeling> wandelingen = this.service.getAll();

        if (wandelingen == null) {
            return new ResponseEntity<Iterable<Wandeling>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Iterable<Wandeling>>(wandelingen, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Wandeling> findWandeling(@PathVariable long id) {
        Wandeling result = this.service.findById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Wandeling> deleteWandeling(@PathVariable long id) {
        this.service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Wandeling> createWandeling(@RequestBody Wandeling wandeling){
        this.service.createWandeling(wandeling);
        return new ResponseEntity<>(wandeling,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Wandeling> updateWandeling(@PathVariable long id, @RequestBody Wandeling wandeling){
        Wandeling result= this.service.updateWandeling(id,wandeling);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}



