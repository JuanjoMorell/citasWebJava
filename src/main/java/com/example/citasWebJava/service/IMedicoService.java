package com.example.citasWebJava.service;

import com.example.citasWebJava.model.Medico;
import com.example.citasWebJava.model.Paciente;

import java.util.List;

public interface IMedicoService {
    public List<Medico> getAll();

    public Medico getMedicoById(Long id);

    public Boolean saveMedico(Medico u);

    public void deleteMedico(Long id);
}
