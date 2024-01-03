package com.registro.usuarios.personasfiestasrelaciones.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="persona_id")
    private long id;
    @NotNull
    private String nombre;
    private int edad;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Habilidad> habilidades= new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference //se usa para evitar bucles infinitos de informacion o errores de recursividad de datos.Se guardan los datos pero no se serializa.
    @JoinTable(name="personas_fiestas",
            joinColumns = @JoinColumn(name = "persona_id",referencedColumnName = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"))
    private List<Fiesta> fiestas = new ArrayList<>();
}

