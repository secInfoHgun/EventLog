package com.hgun.sti.models.dto;

import com.hgun.sti.models.ProvidenciaOcorrencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvidenciaOcorrenciaDTO {
    Long id;
    String acoesDeMelhoria;
    String acoesParaReduzirRiscos;
    Boolean naoCaracterizaEventoAdverso;
    String fatoresAtenuantesDaOcorrencia;
    String data;

    public static ProvidenciaOcorrencia fromDTO(ProvidenciaOcorrenciaDTO providenciaOcorrencia){
        return ProvidenciaOcorrencia.builder()
                .id(providenciaOcorrencia.getId())
                .acoesDeMelhoria(providenciaOcorrencia.getAcoesDeMelhoria())
                .acoesParaReduzirRiscos(providenciaOcorrencia.getAcoesParaReduzirRiscos())
                .naoCaracterizaEventoAdverso(providenciaOcorrencia.getNaoCaracterizaEventoAdverso())
                .fatoresAtenuantesDaOcorrencia(providenciaOcorrencia.getFatoresAtenuantesDaOcorrencia())
                .data(providenciaOcorrencia.getData())
                .build();
    }

    public static ProvidenciaOcorrenciaDTO toDTO(ProvidenciaOcorrencia providenciaOcorrencia){
        return ProvidenciaOcorrenciaDTO.builder()
                .id(providenciaOcorrencia.getId())
                .acoesDeMelhoria(providenciaOcorrencia.getAcoesDeMelhoria())
                .acoesParaReduzirRiscos(providenciaOcorrencia.getAcoesParaReduzirRiscos())
                .naoCaracterizaEventoAdverso(providenciaOcorrencia.getNaoCaracterizaEventoAdverso())
                .fatoresAtenuantesDaOcorrencia(providenciaOcorrencia.getFatoresAtenuantesDaOcorrencia())
                .data(providenciaOcorrencia.getData())
                .build();
    }
}
