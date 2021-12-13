package com.hgun.sti.models.dto;

import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.Paciente;
import com.hgun.sti.models.types.*;
import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaDTO {
    Long id;
    Paciente paciente;
    String resumo;
    String descricao;
    String fatorContribuinte;
    Boolean pacienteFaleceu;
    Boolean pacienteFoiInternado;
    Date data;
    TipoOcorrencia tipoOcorrencia;
    TipoIncidencia tipoIncidencia;
    TipoDano tipoDano;
    TipoSetor tipoSetor;
    TipoFaseAssistencia tipoFaseAssistencia;

    public static Ocorrencia fromDTO(OcorrenciaDTO ocorrencia){
        return Ocorrencia.builder()
                .id(ocorrencia.getId())
                .paciente(ocorrencia.getPaciente())
                .resumo(ocorrencia.getResumo())
                .descricao(ocorrencia.getDescricao())
                .fatorContribuinte(ocorrencia.getFatorContribuinte())
                .pacienteFaleceu(ocorrencia.getPacienteFaleceu())
                .pacienteFoiInternado(ocorrencia.getPacienteFoiInternado())
                .data(ocorrencia.getData())
                .tipoOcorrencia(ocorrencia.getTipoOcorrencia())
                .tipoIncidencia(ocorrencia.getTipoIncidencia())
                .tipoDano(ocorrencia.getTipoDano())
                .tipoSetor(ocorrencia.getTipoSetor())
                .tipoFaseAssistencia(ocorrencia.getTipoFaseAssistencia())
                .build();
    }

    public static OcorrenciaDTO toDTO(Ocorrencia ocorrencia){
        return OcorrenciaDTO.builder()
                .id(ocorrencia.getId())
                .paciente(ocorrencia.getPaciente())
                .resumo(ocorrencia.getResumo())
                .descricao(ocorrencia.getDescricao())
                .fatorContribuinte(ocorrencia.getFatorContribuinte())
                .pacienteFaleceu(ocorrencia.getPacienteFaleceu())
                .pacienteFoiInternado(ocorrencia.getPacienteFoiInternado())
                .data(ocorrencia.getData())
                .tipoOcorrencia(ocorrencia.getTipoOcorrencia())
                .tipoIncidencia(ocorrencia.getTipoIncidencia())
                .tipoDano(ocorrencia.getTipoDano())
                .tipoSetor(ocorrencia.getTipoSetor())
                .tipoFaseAssistencia(ocorrencia.getTipoFaseAssistencia())
                .build();
    }
}
