package com.example.citasWebJava.service;

import com.example.citasWebJava.model.Paciente;
import com.example.citasWebJava.repository.IPacienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteDAO pDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> getAll() {
        return pDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente getPacienteById(Long id) {
        return pDAO.findById(id).get();
    }

    @Override
    @Transactional
    public Boolean savePaciente(Paciente u) {
        if(pDAO.findById(u.getId()).isPresent()) return false;
        pDAO.save(u);
        return true;
    }

    @Override
    @Transactional
    public void deletePaciente(Long id) {
        pDAO.deleteById(id);
    }
}
