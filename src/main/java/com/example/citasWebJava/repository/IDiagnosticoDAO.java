package com.example.citasWebJava.repository;

import com.example.citasWebJava.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiagnosticoDAO extends JpaRepository<Diagnostico,Long> {
}
