package com.example.citasWebJava.service;

import com.example.citasWebJava.model.Usuario;
import com.example.citasWebJava.repository.IUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUsuarioDAO uDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        return uDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioById(Long id) {
        return uDAO.findById(id).get();
    }

    @Override
    @Transactional
    public Boolean saveUsuario(Usuario u) {
        if( uDAO.findById(u.getId()).isPresent()) return false;
        uDAO.save(u);
        return true;
    }

    @Override
    @Transactional
    public void deleteUsuario(Long id) {
        uDAO.deleteById(id);
    }
}
