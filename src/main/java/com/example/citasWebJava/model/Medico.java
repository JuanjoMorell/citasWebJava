package com.example.citasWebJava.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico extends Usuario {

    @Column(name = "Numero_Colegiado")
    private String numeroColegiado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MedicoPaciente",
                joinColumns = @JoinColumn(name = "MedicosId"),
                inverseJoinColumns = @JoinColumn(name = "PacientesId"))
    private List<Paciente> pacientes;

    public Medico() {}

    public Medico(String _nombre, String _apellidos, String _username, String _clave,
                  String _numeroColegiado) {
        super(_nombre, _apellidos, _username, _clave);
        this.numeroColegiado = _numeroColegiado;
        this.pacientes = new ArrayList<Paciente>();
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public List<Paciente> getPacientes() {
        return new ArrayList<Paciente>(pacientes);
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numeroColegiado='" + numeroColegiado + '\'' +
                ", pacientes=" + pacientes +
                '}';
    }
}
