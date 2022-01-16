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
    String outrasProvidencias;
    String data;
    String hora;

    public static Providencia fromDTO(ProvidenciaDTO providencia){
        return Providencia.builder()
                .id(providencia.getId())
                .acoesDeMelhoria(providencia.getAcoesDeMelhoria())
                .acoesParaReduzirRiscos(providencia.getAcoesParaReduzirRiscos())
                .naoCaracterizaEventoAdverso(providencia.getNaoCaracterizaEventoAdverso())
                .outrasProvidencias(providencia.getOutrasProvidencias())
                .data(providencia.getData())
                .hora(providencia.getHora())
                .build();
    }

    public static ProvidenciaDTO toDTO(Providencia providencia){
        return ProvidenciaDTO.builder()
                .id(providencia.getId())
                .acoesDeMelhoria(providencia.getAcoesDeMelhoria())
                .acoesParaReduzirRiscos(providencia.getAcoesParaReduzirRiscos())
                .naoCaracterizaEventoAdverso(providencia.getNaoCaracterizaEventoAdverso())
                .outrasProvidencias(providencia.getOutrasProvidencias())
                .data(providencia.getData())
                .hora(providencia.getHora())
                .build();
    }
}
