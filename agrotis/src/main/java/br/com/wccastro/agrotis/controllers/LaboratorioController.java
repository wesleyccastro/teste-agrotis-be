package br.com.wccastro.agrotis.controllers;

import br.com.wccastro.agrotis.models.LaboratorioModel;
import br.com.wccastro.agrotis.repositories.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaboratorioController {

    @Autowired
    LaboratorioRepository laboratorioRepository;

    @GetMapping("/laboratorios")
    public ResponseEntity<List<LaboratorioModel>> getAll(){
        List<LaboratorioModel> laboratoriosList = laboratorioRepository.findAll();
        if(laboratoriosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<LaboratorioModel>>(laboratoriosList, HttpStatus.OK);
        }
    }

    @GetMapping("/laboratorios/{id}")
    public ResponseEntity<LaboratorioModel> getOneLaboratorio(@PathVariable(value="id") long id){
        Optional<LaboratorioModel> laboratorioO = laboratorioRepository.findById(id);
        if(!laboratorioO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<LaboratorioModel>(laboratorioO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/laboratorios")
    public ResponseEntity<LaboratorioModel> saveLaboratorio(@RequestBody LaboratorioModel laboratorio){
        return  new ResponseEntity<LaboratorioModel>(laboratorioRepository.save(laboratorio), HttpStatus.CREATED);
    }

    @DeleteMapping("/laboratorios/{id}")
    public ResponseEntity<?> deleteLaboratorio(@PathVariable(value="id") long id){
        Optional<LaboratorioModel> laboratorioO = laboratorioRepository.findById(id);
        if(!laboratorioO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            laboratorioRepository.delete(laboratorioO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/laboratorios/{id}")
    public ResponseEntity<LaboratorioModel> updateLaboratorio(@PathVariable(value="id") long id,
                                                  @RequestBody LaboratorioModel laboratorio){
        Optional<LaboratorioModel> laboratorioO = laboratorioRepository.findById(id);
        if(!laboratorioO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            laboratorio.setId(laboratorioO.get().getId());
            return new ResponseEntity<LaboratorioModel>(laboratorioRepository.save(laboratorio), HttpStatus.OK);
        }
    }

}
