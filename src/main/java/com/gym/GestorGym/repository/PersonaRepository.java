package com.gym.GestorGym.repository;

import com.gym.GestorGym.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
