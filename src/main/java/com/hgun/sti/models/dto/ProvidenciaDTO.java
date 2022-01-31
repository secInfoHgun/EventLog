package com.hgun.sti.models.dto;

import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.Providencia;
import com.hgun.sti.models.types.acao.melhoria.TipoAcaoMelhoriaOrganizacao;
import com.hgun.sti.models.types.acao.melhoria.TipoAcaoMelhoriaPaciente;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoOrganizacional;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoPaciente;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoProfissional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvidenciaDTO {

    Long id;
    TipoAcaoMelhoriaPaciente tipoAcaoMelhoriaPaciente;
    TipoAcaoMelhoriaOrganizacao tipoAcaoMelhoriaOrganizacao;
    TipoAcaoReduzirRiscoPaciente tipoAcaoReduzirRiscoPaciente;
    TipoAcaoReduzirRiscoProfissional tipoAcaoReduzirRiscoProfissional;
    TipoAcaoReduzirRiscoOrganizacional tipoAcaoReduzirRiscoOrganizacional;
    Boolean naoAdotadasAcoesReducaoRisco;
    Boolean naoCaracterizaEventoAdverso;
    String outrasProvidencias;
    String data;
    String hora;
    Ocorrencia ocorrencia;

    public static Providencia fromDTO(ProvidenciaDTO providencia){
        return Providencia.builder()
                .id(providencia.getId())
                .tipoAcaoMelhoriaPaciente(providencia.getTipoAcaoMelhoriaPaciente())
                .tipoAcaoMelhoriaOrganizacao(providencia.getTipoAcaoMelhoriaOrganizacao())
                .tipoAcaoReduzirRiscoPaciente(providencia.getTipoAcaoReduzirRiscoPaciente())
                .tipoAcaoReduzirRiscoProfissional(providencia.getTipoAcaoReduzirRiscoProfissional())
                .tipoAcaoReduzirRiscoOrganizacional(providencia.getTipoAcaoReduzirRiscoOrganizacional())
                .naoAdotadasAcoesReducaoRisco(providencia.getNaoAdotadasAcoesReducaoRisco())
                .naoCaracterizaEventoAdverso(providencia.getNaoCaracterizaEventoAdverso())
                .outrasProvidencias(providencia.getOutrasProvidencias())
                .data(providencia.getData())
                .hora(providencia.getHora())
                .ocorrencia(providencia.getOcorrencia())
                .build();
    }

    public static ProvidenciaDTO toDTO(Providencia providencia){
        return ProvidenciaDTO.builder()
                .id(providencia.getId())
                .tipoAcaoMelhoriaPaciente(providencia.getTipoAcaoMelhoriaPaciente())
                .tipoAcaoMelhoriaOrganizacao(providencia.getTipoAcaoMelhoriaOrganizacao())
                .tipoAcaoReduzirRiscoPaciente(providencia.getTipoAcaoReduzirRiscoPaciente())
                .tipoAcaoReduzirRiscoProfissional(providencia.getTipoAcaoReduzirRiscoProfissional())
                .tipoAcaoReduzirRiscoOrganizacional(providencia.getTipoAcaoReduzirRiscoOrganizacional())
                .naoAdotadasAcoesReducaoRisco(providencia.getNaoAdotadasAcoesReducaoRisco())
                .naoCaracterizaEventoAdverso(providencia.getNaoCaracterizaEventoAdverso())
                .outrasProvidencias(providencia.getOutrasProvidencias())
                .data(providencia.getData())
                .hora(providencia.getHora())
                .ocorrencia(providencia.getOcorrencia())
                .build();
    }
}
