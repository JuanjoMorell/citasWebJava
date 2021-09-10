package com.example.citasWebJava.model;

import javax.persistence.*;

@Entity
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "Valoracion_Especialista")
    private String valoracionEspecialista;

    @Column(name = "Enfermedad")
    private String enfermedad;

    public Diagnostico(String _valoracionEspecialista, String _enfermedad)
    {
        this.valoracionEspecialista = _valoracionEspecialista;
        this.enfermedad = _enfermedad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public void setValoracionEspecialista(String valoracionEspecialista) {
        this.valoracionEspecialista = valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "id=" + id +
                ", valoracionEspecialista='" + valoracionEspecialista + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                '}';
    }
}
