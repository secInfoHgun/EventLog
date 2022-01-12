package com.hgun.sti.models.dto;

import com.hgun.sti.models.ObitoOcorrencia;
import com.hgun.sti.models.ProvidenciaOcorrencia;
import com.hgun.sti.models.types.TipoLesao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObitoOcorrenciaDTO {
    Long id;
    String dataDoObito;
    String numeroDaDeclaracao;
    TipoLesao tipoLesao;
    String causaDaMorte;
    String data;

    public static ObitoOcorrencia fromDTO(ObitoOcorrenciaDTO obitoOcorrencia){
        return ObitoOcorrencia.builder()
                .id(obitoOcorrencia.getId())
                .dataDoObito(obitoOcorrencia.getDataDoObito())
                .numeroDaDeclaracao(obitoOcorrencia.getNumeroDaDeclaracao())
                .tipoLesao(obitoOcorrencia.getTipoLesao())
                .causaDaMorte(obitoOcorrencia.getCausaDaMorte())
                .data(obitoOcorrencia.getData())
                .build();
    }

    public static ObitoOcorrenciaDTO toDTO(ObitoOcorrencia obitoOcorrencia){
        return ObitoOcorrenciaDTO.builder()
                .id(obitoOcorrencia.getId())
                .dataDoObito(obitoOcorrencia.getDataDoObito())
                .numeroDaDeclaracao(obitoOcorrencia.getNumeroDaDeclaracao())
                .tipoLesao(obitoOcorrencia.getTipoLesao())
                .causaDaMorte(obitoOcorrencia.getCausaDaMorte())
                .data(obitoOcorrencia.getData())
                .build();
    }
}
