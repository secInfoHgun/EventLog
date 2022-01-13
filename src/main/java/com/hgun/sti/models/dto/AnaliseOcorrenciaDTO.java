package com.hgun.sti.models.dto;

import com.hgun.sti.models.AnaliseOcorrencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnaliseOcorrenciaDTO {
    Long id;
    String fatoresContribuintes;
    String consequenciasOrganizacionais;
    String identificacaoeAnaliseDeFatores;
    String fatoresAtenuantesDaOcorrencia;
    String data;

    public static AnaliseOcorrencia fromDTO(AnaliseOcorrenciaDTO analiseOcorrencia){
        return AnaliseOcorrencia.builder()
                .id(analiseOcorrencia.getId())
                .fatoresContribuintes(analiseOcorrencia.getFatoresContribuintes())
                .consequenciasOrganizacionais(analiseOcorrencia.getConsequenciasOrganizacionais())
                .identificacaoeAnaliseDeFatores(analiseOcorrencia.getIdentificacaoeAnaliseDeFatores())
                .fatoresAtenuantesDaOcorrencia(analiseOcorrencia.getFatoresAtenuantesDaOcorrencia())
                .data(analiseOcorrencia.getData())
                .build();
    }

    public static AnaliseOcorrenciaDTO toDTO(AnaliseOcorrencia analiseOcorrencia){
        return AnaliseOcorrenciaDTO.builder()
                .id(analiseOcorrencia.getId())
                .fatoresContribuintes(analiseOcorrencia.getFatoresContribuintes())
                .consequenciasOrganizacionais(analiseOcorrencia.getConsequenciasOrganizacionais())
                .identificacaoeAnaliseDeFatores(analiseOcorrencia.getIdentificacaoeAnaliseDeFatores())
                .fatoresAtenuantesDaOcorrencia(analiseOcorrencia.getFatoresAtenuantesDaOcorrencia())
                .data(analiseOcorrencia.getData())
                .build();
    }

}
