package com.example.citasWebJava.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Paciente")
public class Paciente extends Usuario {

    @Column(name = "NSS")
    private String nns;

    @Column(name = "Numero_Tarjeta")
    private String numeroTarjeta;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Direccion")
    private String direccion;

    @ManyToMany(mappedBy = "pacientes", fetch = FetchType.EAGER)
    private List<Medico> medicos;

    public Paciente() {}

    public Paciente(String _nombre, String _apellidos, String _username, String _clave,
                    String _nss, String _numeroTarjeta, String _telefono, String _direccion) {
        super(_nombre, _apellidos, _username, _clave);
        this.nns = _nss;
        this.numeroTarjeta = _numeroTarjeta;
        this.telefono = _telefono;
        this.direccion = _direccion;
        this.medicos = new ArrayList<Medico>();
    }

    public void addMedico(Medico m) {
        if(!medicos.contains(m)) medicos.add(m);
    }

    public String getNns() {
        return nns;
    }

    public void setNns(String nns) {
        this.nns = nns;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Medico> getMedicos() {
        return new ArrayList<Medico>(medicos);
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nns='" + nns + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", medicos=" + medicos +
                '}';
    }
}
