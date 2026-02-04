package com.gym.GestorGym.models;
//CONTROLLERS PARA ENDPOINTS
//MODELS PARA CADA CLASE
//DTO DATA TRANSFER OBJECT
//SERVICE C/U SERIVCIO
//REPOSITORIES CONFIG REPO DB

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//@Data tiene todo pros y contras
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
}
