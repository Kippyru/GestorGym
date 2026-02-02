package com.gym.GestorGym.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;

}
