package com.example.citasWebJava.service;

import com.example.citasWebJava.model.Paciente;

import java.util.List;

public interface IPacienteService {

    public List<Paciente> getAll();

    public Paciente getPacienteById(Long id);

    public Boolean savePaciente(Paciente u);

    public void deletePaciente(Long id);
}
