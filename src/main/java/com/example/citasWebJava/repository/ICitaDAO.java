package com.example.citasWebJava.repository;

import com.example.citasWebJava.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaDAO extends JpaRepository<Cita, Long> {
}
