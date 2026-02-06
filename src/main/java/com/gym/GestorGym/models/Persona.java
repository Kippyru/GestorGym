package com.gym.GestorGym.models;
//CONTROLLERS PARA ENDPOINTS
//MODELS PARA CADA CLASE
//DTO DATA TRANSFER OBJECT
//SERVICE C/U SERIVCIO
//REPOSITORIES CONFIG REPO DB

import jakarta.persistence.*;
import lombok.*;

//@Data tiene todo pros y contras
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    @ManyToOne // Muchas personas pueden tener el mismo Rol
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
