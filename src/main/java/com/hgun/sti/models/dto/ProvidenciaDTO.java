package com.hgun.sti.models.dto;

import com.hgun.sti.models.Providencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvidenciaDTO {
    Long id;
    String acoesDeMelhoria;
    String acoesParaReduzirRiscos;
    Boolean naoCaracterizaEventoAdverso;
    String fatoresAtenuantesDaOcorrencia;
    String data;

    public static Providencia fromDTO(ProvidenciaDTO providencia){
        return Providencia.builder()
                .id(providencia.getId())
                .acoesDeMelhoria(providencia.getAcoesDeMelhoria())
                .acoesParaReduzirRiscos(providencia.getAcoesParaReduzirRiscos())
                .naoCaracterizaEventoAdverso(providencia.getNaoCaracterizaEventoAdverso())
                .fatoresAtenuantesDaOcorrencia(providencia.getFatoresAtenuantesDaOcorrencia())
                .data(providencia.getData())
                .build();
    }

    public static ProvidenciaDTO toDTO(Providencia providencia){
        return ProvidenciaDTO.builder()
                .id(providencia.getId())
                .acoesDeMelhoria(providencia.getAcoesDeMelhoria())
                .acoesParaReduzirRiscos(providencia.getAcoesParaReduzirRiscos())
                .naoCaracterizaEventoAdverso(providencia.getNaoCaracterizaEventoAdverso())
                .fatoresAtenuantesDaOcorrencia(providencia.getFatoresAtenuantesDaOcorrencia())
                .data(providencia.getData())
                .build();
    }
}
