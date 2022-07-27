package br.com.wccastro.agrotis.controllers;

import br.com.wccastro.agrotis.models.TesteModel;
import br.com.wccastro.agrotis.repositories.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TesteController {

    @Autowired
    TesteRepository testeRepository;

    @GetMapping("/testes")
    public ResponseEntity<List<TesteModel>> getAllTestes(){
        List<TesteModel> testesList = testeRepository.findAll();
        if(testesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<TesteModel>>(testesList, HttpStatus.OK);
        }
    }

    @GetMapping("/testes/{id}")
    public ResponseEntity<TesteModel> getOneTeste(@PathVariable(value="id") long id){
        Optional<TesteModel> testeO = testeRepository.findById(id);
        if(!testeO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<TesteModel>(testeO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/testes")
    public ResponseEntity<TesteModel> saveTeste(@RequestBody TesteModel teste){
        return  new ResponseEntity<TesteModel>(testeRepository.save(teste), HttpStatus.CREATED);
    }

    @DeleteMapping("/testes/{id}")
    public ResponseEntity<?> deleteTeste(@PathVariable(value="id") long id){
        Optional<TesteModel> testeO = testeRepository.findById(id);
        if(!testeO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            testeRepository.delete(testeO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/testes/{id}")
    public ResponseEntity<TesteModel> updateTeste(@PathVariable(value="id") long id,
                                                  @RequestBody TesteModel teste){
        Optional<TesteModel> testeO = testeRepository.findById(id);
        if(!testeO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            teste.setId(testeO.get().getId());
            return new ResponseEntity<TesteModel>(testeRepository.save(teste), HttpStatus.OK);
        }
    }

}
