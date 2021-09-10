package com.example.citasWebJava;

import com.example.citasWebJava.dto.*;
import com.example.citasWebJava.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper implements IMapper {

    private ModelMapper mapper = new ModelMapper();

    @Override
    public UsuarioDTO usuarioToDTO(Usuario u) {
        return mapper.map(u, UsuarioDTO.class);
    }

    @Override
    public Usuario dtoToUsuario(UsuarioDTO uDTO) {
        return mapper.map(uDTO, Usuario.class);
    }

    @Override
    public PacienteDTO pacienteToDTO(Paciente p) {
        PacienteDTO pDTO = mapper.typeMap(Paciente.class, PacienteDTO.class)
                                 .addMappings(m -> m.skip(PacienteDTO::setMedicos))
                                 .map(p);

        // Add lista de ids de medicos
        pDTO.setMedicos(p.getMedicos().stream().map(m -> m.getId()).collect(Collectors.toList()));
        return pDTO;
    }

    @Override
    public Paciente dtoToPaciente(PacienteDTO pDTO) {
        return mapper.map(pDTO, Paciente.class);
    }

    @Override
    public MedicoDTO medicoToDTO(Medico m) {
        MedicoDTO mDTO = mapper.typeMap(Medico.class, MedicoDTO.class)
                .addMappings(mp -> mp.skip(MedicoDTO::setPacientes))
                .map(m);

        // Add lista de ids de medicos
        mDTO.setPacientes(m.getPacientes().stream().map(p -> p.getId()).collect(Collectors.toList()));
        return mDTO;
    }

    @Override
    public Medico dtoToMedico(MedicoDTO mDTO) {
        return mapper.map(mDTO, Medico.class);
    }

    @Override
    public DiagnosticoDTO diagToDTO(Diagnostico d) {
        return mapper.map(d, DiagnosticoDTO.class);
    }

    @Override
    public Diagnostico dtoToDiag(DiagnosticoDTO dDTO) {
        return mapper.map(dDTO, Diagnostico.class);
    }

    @Override
    public CitaDTO citaToDTO(Cita c) {
        CitaDTO cDTO = mapper.typeMap(Cita.class, CitaDTO.class)
                            .addMappings(mp -> mp.skip(CitaDTO::setMedico))
                            .addMappings(mp -> mp.skip((CitaDTO::setPaciente)))
                            .map(c);
        cDTO.setMedico(c.getMedico().getId());
        cDTO.setPaciente(c.getPaciente().getId());
        return cDTO;
    }

    @Override
    public Cita dtoToCita(CitaDTO cDTO, Medico m, Paciente p) {
        Cita c = mapper.typeMap(CitaDTO.class, Cita.class)
                        .addMappings(mp -> mp.skip(Cita::setMedico))
                        .addMappings(mp -> mp.skip(Cita::setPaciente))
                        .addMappings(mp -> mp.skip(Cita::setDiagnostico))
                        .map(cDTO);
        c.setMedico(m);
        c.setPaciente(p);
        return c;
    }
}
