package com.gym.GestorGym.repository;

import com.gym.GestorGym.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Optional<Persona> findEmailPersona(String email);
}
