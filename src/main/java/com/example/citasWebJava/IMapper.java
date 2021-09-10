package com.example.citasWebJava;

import com.example.citasWebJava.model.*;
import com.example.citasWebJava.dto.*;

public interface IMapper {

    public UsuarioDTO usuarioToDTO(Usuario u);
    public Usuario dtoToUsuario(UsuarioDTO uDTO);

    public PacienteDTO pacienteToDTO(Paciente p);
    public Paciente dtoToPaciente(PacienteDTO pDTO);

    public MedicoDTO medicoToDTO(Medico m);
    public Medico dtoToMedico(MedicoDTO mDTO);

    public DiagnosticoDTO diagToDTO(Diagnostico d);
    public Diagnostico dtoToDiag(DiagnosticoDTO dDTO);

    public CitaDTO citaToDTO(Cita c);
    public Cita dtoToCita(CitaDTO c, Medico m, Paciente p);
}
