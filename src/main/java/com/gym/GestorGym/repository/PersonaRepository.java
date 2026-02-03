package com.gym.GestorGym.repository;

import com.gym.GestorGym.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
