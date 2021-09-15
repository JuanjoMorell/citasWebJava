package com.example.citasWebJava.controller;

import com.example.citasWebJava.Mapper;
import com.example.citasWebJava.dto.MedicoDTO;
import com.example.citasWebJava.model.Medico;
import com.example.citasWebJava.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private IMedicoService mService;
    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> getAllMedicos() {
        // Obtener la lista de usuarios
        List<MedicoDTO> mDTOs = new ArrayList<MedicoDTO>();
        mService.getAll().stream().forEach(m -> mDTOs.add(mapper.medicoToDTO(m)));
        return ResponseEntity.ok(mDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> getMedico(@PathVariable Long id) {
        Medico m = mService.getMedicoById(id);
        if(m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.medicoToDTO(m));
    }

    @PostMapping
    public ResponseEntity<String> saveMedico(@RequestBody MedicoDTO mDTO) {
        Medico m = mapper.dtoToMedico(mDTO);
        boolean alm = mService.saveMedico(m);
        if(alm) return ResponseEntity.ok("Medico almacenado correctamente.");
        else return ResponseEntity.status(412).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable Long id) {
        mService.deleteMedico(id);
        return ResponseEntity.ok("Medico eliminado correctamente.");
    }
}
