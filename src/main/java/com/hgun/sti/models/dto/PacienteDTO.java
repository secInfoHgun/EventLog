package com.hgun.sti.models.dto;

import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {
    Long id;
    String preccp;
    String nome;
    String idade;
    Character sexo;

    public static Paciente fromDTO(PacienteDTO paciente){
        return Paciente.builder()
                .id(paciente.getId())
                .preccp(paciente.getPreccp())
                .nome(paciente.getNome())
                .idade(paciente.getIdade())
                .sexo(paciente.getSexo())
                .build();
    }

    public static PacienteDTO toDTO(Paciente paciente){
        return PacienteDTO.builder()
                .id(paciente.getId())
                .preccp(paciente.getPreccp())
                .nome(paciente.getNome())
                .idade(paciente.getIdade())
                .sexo(paciente.getSexo())
                .build();
    }
}
