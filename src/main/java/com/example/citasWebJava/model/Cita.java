package com.example.citasWebJava.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "FechaHora")
    private Date fechaHora;

    @Column(name = "Motivo_Cita")
    private String motivoCita;

    @Column(name = "Attribute11")
    private int attribute11;

    @OneToOne
    @Column(name = "Paciente")
    private Paciente paciente;

    @OneToOne
    @Column(name = "Medico")
    private Medico medico;

    @OneToOne
    @Column(name = "Diagnostico")
    private Diagnostico diagnostico;

    public Cita(Date _fechaHora, String _motivoCita, int _attribute11,
                Paciente _paciente, Medico _medico)
    {
        this.fechaHora = _fechaHora;
        this.motivoCita = _motivoCita;
        this.attribute11 = _attribute11;
        this.paciente = _paciente;
        this.medico = _medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public int getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(int attribute11) {
        this.attribute11 = attribute11;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", motivoCita='" + motivoCita + '\'' +
                ", attribute11=" + attribute11 +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", diagnostico=" + diagnostico +
                '}';
    }
}
