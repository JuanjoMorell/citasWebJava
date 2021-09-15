package com.example.citasWebJava.controller;

import com.example.citasWebJava.Mapper;
import com.example.citasWebJava.dto.UsuarioDTO;
import com.example.citasWebJava.model.Usuario;
import com.example.citasWebJava.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uService;
    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        // Obtener la lista de usuarios
        List<UsuarioDTO> uDTOs = new ArrayList<UsuarioDTO>();
        uService.getAll().stream().forEach(us -> uDTOs.add(mapper.usuarioToDTO(us)));
        return ResponseEntity.ok(uDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        Usuario us = uService.getUsuarioById(id);
        if(us == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.usuarioToDTO(us));
    }

    @PostMapping
    public ResponseEntity<String> saveUsuario(@RequestBody UsuarioDTO uDTO) {
        Usuario us = mapper.dtoToUsuario(uDTO);
        boolean alm = uService.saveUsuario(us);
        if(alm) return ResponseEntity.ok("Usuario almacenado correctamente.");
        else return ResponseEntity.status(412).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        uService.deleteUsuario(id);
        return ResponseEntity.ok("Usuario eleminado correctamente.");
    }
}
