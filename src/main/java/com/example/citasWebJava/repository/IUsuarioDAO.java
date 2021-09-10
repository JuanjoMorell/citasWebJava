package com.example.citasWebJava.repository;

import com.example.citasWebJava.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario,Long> {
}
