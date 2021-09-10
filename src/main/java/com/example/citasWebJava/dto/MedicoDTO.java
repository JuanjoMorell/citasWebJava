package com.example.citasWebJava.dto;

import java.util.ArrayList;
import java.util.List;

public class MedicoDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String username;
    private String clave;
    private String numeroColegiado;
    private List<Long> pacientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public List<Long> getPacientes() {
        return new ArrayList<Long>(pacientes);
    }

    public void setPacientes(List<Long> pacientes) {
        this.pacientes = pacientes;
    }
}
