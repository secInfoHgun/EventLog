package com.hgun.sti.models.dto;

import com.hgun.sti.models.Analise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnaliseDTO {
    Long id;
    String fatoresContribuintes;
    String consequenciasOrganizacionais;
    String identificacaoeAnaliseDeFatores;
    String fatoresAtenuantesDaOcorrencia;
    String data;

    public static Analise fromDTO(AnaliseDTO analise){
        return Analise.builder()
                .id(analise.getId())
                .fatoresContribuintes(analise.getFatoresContribuintes())
                .consequenciasOrganizacionais(analise.getConsequenciasOrganizacionais())
                .identificacaoeAnaliseDeFatores(analise.getIdentificacaoeAnaliseDeFatores())
                .fatoresAtenuantesDaOcorrencia(analise.getFatoresAtenuantesDaOcorrencia())
                .data(analise.getData())
                .build();
    }

    public static AnaliseDTO toDTO(Analise analise){
        return AnaliseDTO.builder()
                .id(analise.getId())
                .fatoresContribuintes(analise.getFatoresContribuintes())
                .consequenciasOrganizacionais(analise.getConsequenciasOrganizacionais())
                .identificacaoeAnaliseDeFatores(analise.getIdentificacaoeAnaliseDeFatores())
                .fatoresAtenuantesDaOcorrencia(analise.getFatoresAtenuantesDaOcorrencia())
                .data(analise.getData())
                .build();
    }

}
