package br.com.wccastro.agrotis.controllers;

import br.com.wccastro.agrotis.models.PropriedadeModel;
import br.com.wccastro.agrotis.repositories.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PropriedadeController {

    @Autowired
    PropriedadeRepository propriedadeRepository;

    @GetMapping("/propriedades")
    public ResponseEntity<List<PropriedadeModel>> getAll(){
        List<PropriedadeModel> propriedadesList = propriedadeRepository.findAll();
        if(propriedadesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<PropriedadeModel>>(propriedadesList, HttpStatus.OK);
        }
    }

    @GetMapping("/propriedades/{id}")
    public ResponseEntity<PropriedadeModel> getOnePropriedade(@PathVariable(value="id") long id){
        Optional<PropriedadeModel> propriedadeO = propriedadeRepository.findById(id);
        if(!propriedadeO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<PropriedadeModel>(propriedadeO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/propriedades")
    public ResponseEntity<PropriedadeModel> savePropriedade(@RequestBody PropriedadeModel propriedade){
        return  new ResponseEntity<PropriedadeModel>(propriedadeRepository.save(propriedade), HttpStatus.CREATED);
    }

    @DeleteMapping("/propriedades/{id}")
    public ResponseEntity<?> deletePropriedade(@PathVariable(value="id") long id){
        Optional<PropriedadeModel> propriedadeO = propriedadeRepository.findById(id);
        if(!propriedadeO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            propriedadeRepository.delete(propriedadeO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/propriedades/{id}")
    public ResponseEntity<PropriedadeModel> updatePropriedade(@PathVariable(value="id") long id,
                                                              @RequestBody PropriedadeModel propriedade){
        Optional<PropriedadeModel> propriedadeO = propriedadeRepository.findById(id);
        if(!propriedadeO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            propriedade.setId(propriedadeO.get().getId());
            return new ResponseEntity<PropriedadeModel>(propriedadeRepository.save(propriedade), HttpStatus.OK);
        }
    }

}
