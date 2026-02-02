package com.gym.GestorGym.models;
//CONTROLLERS PARA ENDPOINTS
//MODELS PARA CADA CLASE
//DTO DATA TRANSFER OBJECT
//SERVICE C/U SERIVCIO
//REPOSITORIES CONFIG REPO DB

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data tiene todo pros y contras
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
}
