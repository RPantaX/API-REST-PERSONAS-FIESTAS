package com.registro.usuarios.personasfiestasrelaciones.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fiestas")
public class Fiesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fiesta_id")
    private long id;
    private String ubicacion;
    @Column(name="fiesta_fecha")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fecha;
    @ManyToMany
    @JoinTable(name="personas_fiestas",
            joinColumns = @JoinColumn(name = "fiesta_id",referencedColumnName = "fiesta_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"))
    private List<Persona> personas = new ArrayList<>();
}
