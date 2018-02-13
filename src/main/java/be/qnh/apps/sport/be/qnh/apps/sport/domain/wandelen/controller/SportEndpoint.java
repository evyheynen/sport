package be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.controller;

import be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.service.Wandeling;
import be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.service.WandelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wandelingen")
public class SportEndpoint {

    @Autowired
    private WandelingService service;

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Wandeling>> getAll(){

        Iterable<Wandeling> wandelingen = this.service.getAll();

        if(wandelingen == null) {
            return new ResponseEntity<Iterable<Wandeling>>(HttpStatus.NOT_FOUND);
        }
            else{
                return new ResponseEntity<Iterable<Wandeling>>(wandelingen,HttpStatus.OK);
            }
        }
    }



