package com.example.citasWebJava.service;

import com.example.citasWebJava.model.Medico;
import com.example.citasWebJava.repository.IMedicoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedicoDAO mDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Medico> getAll() {
        return mDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Medico getMedicoById(Long id) {
        return mDAO.findById(id).get();
    }

    @Override
    @Transactional
    public Boolean saveMedico(Medico u) {
        if (mDAO.findById(u.getId()).isPresent()) return false;
        mDAO.save(u);
        return true;
    }

    @Override
    @Transactional
    public void deleteMedico(Long id) {
        mDAO.deleteById(id);
    }
}
