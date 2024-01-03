package com.registro.usuarios.personasfiestasrelaciones.controllers;

import com.registro.usuarios.personasfiestasrelaciones.entities.Fiesta;
import com.registro.usuarios.personasfiestasrelaciones.entities.Persona;
import com.registro.usuarios.personasfiestasrelaciones.repositories.FiestaRepository;
import com.registro.usuarios.personasfiestasrelaciones.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fiestas")
public class FiestaController {
    @Autowired
    private FiestaRepository fiestaRepository;
    @GetMapping()
    private ResponseEntity<List<Fiesta>> listarFiestas(){
        return new ResponseEntity<>((List<Fiesta>)fiestaRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fiesta> obtenerFiestaPorId(@PathVariable Long id){
        Fiesta fiesta= fiestaRepository.findById(id).orElseThrow();

        if(fiesta!=null){
            return new ResponseEntity<>(fiestaRepository.findById(id).orElseThrow(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<?> guardarFiesta(@RequestBody Fiesta fiesta){
        return new ResponseEntity<>(fiestaRepository.save(fiesta), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFiesta(@PathVariable long id){
        fiestaRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
