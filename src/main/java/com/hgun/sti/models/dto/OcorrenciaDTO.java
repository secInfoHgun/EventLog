package com.hgun.sti.models.dto;

import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.Paciente;
import com.hgun.sti.models.types.*;
import lombok.*;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaDTO {
    Long id;
    Paciente paciente;
    String resumo;
    String descricao;
    String diagnostico;
    String fatorContribuinte;
    Boolean pacienteFaleceu;
    Boolean pacienteFoiInternado;
    String dataDaOcorrencia;
    String horaDaOcorrencia;
    String dataDaInternacao;
    String horaDaInternacao;
    TipoOcorrencia tipoOcorrencia;
    TipoIncidencia tipoIncidencia;
    TipoDano tipoDano;
    TipoSetor tipoSetor;
    TipoFaseAssistencia tipoFaseAssistencia;
    TipoIdentificacao tipoIdentificacao;
    TipoIdentificador tipoIdentificador;

    public static Ocorrencia fromDTO(OcorrenciaDTO ocorrencia){
        return Ocorrencia.builder()
                .id(ocorrencia.getId())
                .paciente(ocorrencia.getPaciente())
                .resumo(ocorrencia.getResumo())
                .descricao(ocorrencia.getDescricao())
                .diagnostico(ocorrencia.getDiagnostico())
                .fatorContribuinte(ocorrencia.getFatorContribuinte())
                .pacienteFaleceu(ocorrencia.getPacienteFaleceu())
                .pacienteFoiInternado(ocorrencia.getPacienteFoiInternado())
                .dataDaOcorrencia(ocorrencia.getDataDaOcorrencia())
                .horaDaOcorrencia(ocorrencia.getHoraDaOcorrencia())
                .dataDaInternacao(ocorrencia.getDataDaInternacao())
                .horaDaInternacao(ocorrencia.getHoraDaInternacao())
                .tipoOcorrencia(ocorrencia.getTipoOcorrencia())
                .tipoIncidencia(ocorrencia.getTipoIncidencia())
                .tipoDano(ocorrencia.getTipoDano())
                .tipoSetor(ocorrencia.getTipoSetor())
                .tipoFaseAssistencia(ocorrencia.getTipoFaseAssistencia())
                .tipoIdentificacao(ocorrencia.getTipoIdentificacao())
                .tipoIdentificador(ocorrencia.getTipoIdentificador())
                .build();
    }

    public static OcorrenciaDTO toDTO(Ocorrencia ocorrencia){
        return OcorrenciaDTO.builder()
                .id(ocorrencia.getId())
                .paciente(ocorrencia.getPaciente())
                .resumo(ocorrencia.getResumo())
                .descricao(ocorrencia.getDescricao())
                .diagnostico(ocorrencia.getDiagnostico())
                .fatorContribuinte(ocorrencia.getFatorContribuinte())
                .pacienteFaleceu(ocorrencia.getPacienteFaleceu())
                .pacienteFoiInternado(ocorrencia.getPacienteFoiInternado())
                .dataDaOcorrencia(ocorrencia.getDataDaOcorrencia())
                .horaDaOcorrencia(ocorrencia.getHoraDaOcorrencia())
                .dataDaInternacao(ocorrencia.getDataDaInternacao())
                .horaDaInternacao(ocorrencia.getHoraDaInternacao())
                .tipoOcorrencia(ocorrencia.getTipoOcorrencia())
                .tipoIncidencia(ocorrencia.getTipoIncidencia())
                .tipoDano(ocorrencia.getTipoDano())
                .tipoSetor(ocorrencia.getTipoSetor())
                .tipoFaseAssistencia(ocorrencia.getTipoFaseAssistencia())
                .tipoIdentificacao(ocorrencia.getTipoIdentificacao())
                .tipoIdentificador(ocorrencia.getTipoIdentificador())
                .build();
    }
}
