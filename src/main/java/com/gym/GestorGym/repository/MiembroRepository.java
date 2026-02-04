package com.gym.GestorGym.repository;

import com.gym.GestorGym.models.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroRepository extends JpaRepository <Miembro, Integer> {
}
