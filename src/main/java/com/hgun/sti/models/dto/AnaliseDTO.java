package com.hgun.sti.models.dto;

import com.hgun.sti.models.Analise;
import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.types.TipoConsequenciaOrganizacional;
import com.hgun.sti.models.types.fator.atenuante.*;
import com.hgun.sti.models.types.fator.contribuinte.*;
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
    TipoConsequenciaOrganizacional tipoConsequenciaOrganizacional;
    TipoFatorContribuinteCognitivo tipoFatorContribuinteCognitivo;
    TipoFatorContribuinteComportamento tipoFatorContribuinteComportamento;
    TipoFatorContribuinteComunicacao tipoFatorContribuinteComunicacao;
    TipoFatorContribuinteDesenpenho tipoFatorContribuinteDesenpenho;
    TipoFatorContribuinteOrganizacional tipoFatorContribuinteOrganizacional;
    TipoFatorContribuintePaciente tipoFatorContribuintePaciente;
    TipoFatorContribuinteProfissional tipoFatorContribuinteProfissional;
    TipoFatorContribuinteTrabalho tipoFatorContribuinteTrabalho;
    TipoFatorAtenuanteAgente tipoFatorAtenuanteAgente;
    TipoFatorAtenuanteOrganizacao tipoFatorAtenuanteOrganizacao;
    TipoFatorAtenuantePaciente tipoFatorAtenuantePaciente;
    TipoFatorAtenuanteProfissional tipoFatorAtenuanteProfissional;
    String data;
    String hora;
    Ocorrencia ocorrencia;

    public static Analise fromDTO(AnaliseDTO analise){
        return Analise.builder()
                .id(analise.getId())
                .tipoConsequenciaOrganizacional(analise.getTipoConsequenciaOrganizacional())
                .tipoFatorContribuinteCognitivo(analise.getTipoFatorContribuinteCognitivo())
                .tipoFatorContribuinteComportamento(analise.getTipoFatorContribuinteComportamento())
                .tipoFatorContribuinteComunicacao(analise.getTipoFatorContribuinteComunicacao())
                .tipoFatorContribuinteDesenpenho(analise.getTipoFatorContribuinteDesenpenho())
                .tipoFatorContribuinteOrganizacional(analise.getTipoFatorContribuinteOrganizacional())
                .tipoFatorContribuintePaciente(analise.getTipoFatorContribuintePaciente())
                .tipoFatorContribuinteProfissional(analise.getTipoFatorContribuinteProfissional())
                .tipoFatorContribuinteTrabalho(analise.getTipoFatorContribuinteTrabalho())
                .tipoFatorAtenuanteAgente(analise.getTipoFatorAtenuanteAgente())
                .tipoFatorAtenuanteOrganizacao(analise.getTipoFatorAtenuanteOrganizacao())
                .tipoFatorAtenuantePaciente(analise.getTipoFatorAtenuantePaciente())
                .tipoFatorAtenuanteProfissional(analise.getTipoFatorAtenuanteProfissional())
                .data(analise.getData())
                .hora(analise.getHora())
                .ocorrencia(analise.getOcorrencia())
                .build();
    }

    public static AnaliseDTO toDTO(Analise analise){
        return AnaliseDTO.builder()
                .id(analise.getId())
                .tipoConsequenciaOrganizacional(analise.getTipoConsequenciaOrganizacional())
                .tipoFatorContribuinteCognitivo(analise.getTipoFatorContribuinteCognitivo())
                .tipoFatorContribuinteComportamento(analise.getTipoFatorContribuinteComportamento())
                .tipoFatorContribuinteComunicacao(analise.getTipoFatorContribuinteComunicacao())
                .tipoFatorContribuinteDesenpenho(analise.getTipoFatorContribuinteDesenpenho())
                .tipoFatorContribuinteOrganizacional(analise.getTipoFatorContribuinteOrganizacional())
                .tipoFatorContribuintePaciente(analise.getTipoFatorContribuintePaciente())
                .tipoFatorContribuinteProfissional(analise.getTipoFatorContribuinteProfissional())
                .tipoFatorContribuinteTrabalho(analise.getTipoFatorContribuinteTrabalho())
                .tipoFatorAtenuanteAgente(analise.getTipoFatorAtenuanteAgente())
                .tipoFatorAtenuanteOrganizacao(analise.getTipoFatorAtenuanteOrganizacao())
                .tipoFatorAtenuantePaciente(analise.getTipoFatorAtenuantePaciente())
                .tipoFatorAtenuanteProfissional(analise.getTipoFatorAtenuanteProfissional())
                .data(analise.getData())
                .hora(analise.getHora())
                .ocorrencia(analise.getOcorrencia())
                .build();
    }

}
