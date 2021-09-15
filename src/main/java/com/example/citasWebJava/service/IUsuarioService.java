package com.example.citasWebJava.service;

import com.example.citasWebJava.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> getAll();

    public Usuario getUsuarioById(Long id);

    public Boolean saveUsuario(Usuario u);

    public void deleteUsuario(Long id);
}
