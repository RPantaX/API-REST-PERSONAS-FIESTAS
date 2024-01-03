package com.registro.usuarios.personasfiestasrelaciones.repositories;

import com.registro.usuarios.personasfiestasrelaciones.entities.Fiesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FiestaRepository extends CrudRepository<Fiesta, Long> {
}
