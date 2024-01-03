package com.registro.usuarios.personasfiestasrelaciones.controllers;

import com.registro.usuarios.personasfiestasrelaciones.entities.Fiesta;
import com.registro.usuarios.personasfiestasrelaciones.entities.Persona;
import com.registro.usuarios.personasfiestasrelaciones.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;
    @GetMapping()
    private ResponseEntity<List<Persona>> listarPersonas(){
        return new ResponseEntity<>((List<Persona>)personaRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable long id){
        Persona persona= personaRepository.findById(id).orElseThrow();

        if(persona!=null){
            return new ResponseEntity<>(personaRepository.findById(id).orElseThrow(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> guardarPersona(@RequestBody Persona persona){
        return new ResponseEntity<>(personaRepository.save(persona), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable long id){
        personaRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/{id}/fiestas")
    public ResponseEntity<List<Fiesta>> liestarFiestasDePersona(@PathVariable long id){
        Persona persona= personaRepository.findById(id).orElseThrow();

        if(persona != null){
            return new ResponseEntity<>((List<Fiesta>)persona.getFiestas(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
