package com.example.citasWebJava.controller;

import com.example.citasWebJava.Mapper;
import com.example.citasWebJava.dto.PacienteDTO;
import com.example.citasWebJava.dto.UsuarioDTO;
import com.example.citasWebJava.model.Paciente;
import com.example.citasWebJava.model.Usuario;
import com.example.citasWebJava.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pService;
    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        // Obtener la lista de usuarios
        List<PacienteDTO> pDTOs = new ArrayList<PacienteDTO>();
        pService.getAll().stream().forEach(p -> pDTOs.add(mapper.pacienteToDTO(p)));
        return ResponseEntity.ok(pDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPaciente(@PathVariable Long id) {
        Paciente p = pService.getPacienteById(id);
        if(p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.pacienteToDTO(p));
    }

    @PostMapping
    public ResponseEntity<String> savePaciente(@RequestBody PacienteDTO pDTO) {
        Paciente p = mapper.dtoToPaciente(pDTO);
        boolean alm = pService.savePaciente(p);
        if(alm) return ResponseEntity.ok("Paciente almacenado correctamente.");
        else return ResponseEntity.status(412).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id) {
        pService.deletePaciente(id);
        return ResponseEntity.ok("Paciente eliminado correctamente.");
    }
}
