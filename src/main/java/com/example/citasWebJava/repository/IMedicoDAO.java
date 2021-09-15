package com.example.citasWebJava.repository;

import com.example.citasWebJava.model.Medico;
import com.example.citasWebJava.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico,Long> {

    @Query(value = "SELECT * FROM Paciente p\r\n"
            + "WHERE p.id IN (SELECT PacientesID FROM MedicoPaciente \r\n"
            + "     WHERE MedicosID = ?1)",
            nativeQuery = true)

    public List<Paciente> findPacientes(Long id);

    public List<Medico> findMedicoByUsername(String username);

}
