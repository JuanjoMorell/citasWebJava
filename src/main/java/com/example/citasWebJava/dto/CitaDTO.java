package com.example.citasWebJava.dto;

import java.util.Date;

public class CitaDTO {

    private Long id;
    private Date fechaHora;
    private String motivoCita;
    private int attribute11;
    private Long paciente;
    private Long medico;
    private Long diagnostico;

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

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public Long getMedico() {
        return medico;
    }

    public void setMedico(Long medico) {
        this.medico = medico;
    }

    public Long getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Long diagnostico) {
        this.diagnostico = diagnostico;
    }
}
