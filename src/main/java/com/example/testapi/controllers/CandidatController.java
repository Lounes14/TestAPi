package com.example.testapi.controllers;

import com.example.testapi.pojos.Candidat;
import com.example.testapi.repositories.CandidatRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value="/api/candidats")

public class CandidatController {
    @Autowired
    private CandidatRepository candidatRepository;

    @GetMapping(value = "/")
//url=/opi/candidats/
    List<Candidat> all() {
        return candidatRepository.findAll();
    }

    @GetMapping(value = "/{candidat}")
//url/candidats/1
    Candidat getOne(@PathVariable(name = "candidat", required = false) Candidat candidat) {
        if (candidat == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Candidat introuvable"
            );
        } else {
            return candidat;
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<Candidat> saveCandidat(@Valid @RequestBody Candidat candidat/*,BindingResult bindingResult*/) {
       /* if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, bindingResult.toString());
        } else
        {*/
            //engistre le candidat dans la BDD
            candidatRepository.save(candidat);
            // retourne le candidat engestré dans la BDD avec son id de renseigné
            return new ResponseEntity<>(candidat, HttpStatus.CREATED);
        //}
    }

    @PutMapping(value = "/{candidat}")//url=/api/candidats/1
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(name="candidat",required = false)Candidat candidat,
                                                   @Valid @RequestBody Candidat candidatUpdate /*, BindingResult bindingResult*/) {
       if (candidat == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Candidat introuvable"
            );

        } else /*{
           if (bindingResult.hasErrors()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, bindingResult.toString()
                );
            } else {*/
                //renseigne l'id du candidat à mettre à jour
                candidatUpdate.setId(candidat.getId());
                //met à jour le candidat dans la BDD
                candidatRepository.save(candidatUpdate);
                //retourne le candidat mis à jour dans la BDD avec son id de renseigné
                return new ResponseEntity<>(candidat, HttpStatus.CREATED);
           // }
       // }
    }
    @DeleteMapping(value = "/{candidat}")
    public void deleteOne (@PathVariable(name="candidat",required = false)Candidat candidat){
        if(candidat== null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Candidat introuvable"
            );
        }else {
            candidatRepository.delete(candidat);
        }
    }
}
