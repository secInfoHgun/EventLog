package com.hgun.sti.models.dto;

import com.hgun.sti.models.Obito;
import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.types.TipoLesao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObitoDTO {
    Long id;
    String dataDoObito;
    String numeroDaDeclaracao;
    TipoLesao tipoLesao;
    String causaDaMorte;
    String data;
    String hora;
    Ocorrencia ocorrencia;

    public static Obito fromDTO(ObitoDTO obito){
        return Obito.builder()
                .id(obito.getId())
                .dataDoObito(obito.getDataDoObito())
                .numeroDaDeclaracao(obito.getNumeroDaDeclaracao())
                .tipoLesao(obito.getTipoLesao())
                .causaDaMorte(obito.getCausaDaMorte())
                .data(obito.getData())
                .hora(obito.getHora())
                .ocorrencia(obito.getOcorrencia())
                .build();
    }

    public static ObitoDTO toDTO(Obito obito){
        return ObitoDTO.builder()
                .id(obito.getId())
                .dataDoObito(obito.getDataDoObito())
                .numeroDaDeclaracao(obito.getNumeroDaDeclaracao())
                .tipoLesao(obito.getTipoLesao())
                .causaDaMorte(obito.getCausaDaMorte())
                .data(obito.getData())
                .hora(obito.getHora())
                .ocorrencia(obito.getOcorrencia())
                .build();
    }
}
