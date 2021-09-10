package com.example.citasWebJava.repository;

import com.example.citasWebJava.model.Medico;
import com.example.citasWebJava.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteDAO extends JpaRepository<Paciente, Long> {

    @Query(value = "SELECT * FROM Paciente p\r\n"
                    + "WHERE p.id IN (SELECT paciente FROM MedicoPaciente \r\n"
                    + "     WHERE medico = ?1)",
            nativeQuery = true)


    public List<Medico> findMedicos(Long id);
    public List<Paciente> findPacienteByUser(String username);
}
