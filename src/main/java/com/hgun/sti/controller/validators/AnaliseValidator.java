package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Analise;
import com.hgun.sti.models.errors.AnaliseError;

public class AnaliseValidator {
    public static AnaliseError validarAnalise(Analise analise){

        var analiseError = new AnaliseError();

        if(analise.getTipoConsequenciaOrganizacional() == null) {
            analiseError.setTipoConsequenciaOrganizacional("A consequência organizacional não pode ser vazia!");
        }

        if(analise.getTipoFatorContribuinteCognitivo() == null) {
            analiseError.setTipoFatorContribuinteCognitivo("O fator contribuinte cognitivo não pode ser vazio!");
        }

        if(analise.getTipoFatorContribuinteComportamento() == null) {
            analiseError.setTipoFatorContribuinteComportamento("O fator contribuinte comportamental não pode ser vazio!");
        }

        if(analise.getTipoFatorContribuinteComunicacao() == null) {
            analiseError.setTipoFatorContribuinteComunicacao("O fator contribuinte de comunicação não pode ser vazio!");
        }

        if(analise.getTipoFatorContribuinteDesenpenho() == null) {
            analiseError.setTipoFatorContribuinteDesenpenho("O fator contribuinte de desempenho não pode ser vazio!");
        }

        if(analise.getTipoFatorContribuinteOrganizacional() == null) {
            analiseError.setTipoFatorContribuinteOrganizacional("O fator contribuinte organizacional não pode ser vazio!");
        }

        if(analise.getTipoFatorContribuintePaciente() == null) {
            analiseError.setTipoFatorContribuintePaciente("O fator contribuinte do paciente não pode ser vazio!");
        }

        if(analise.getTipoFatorContribuinteProfissional() == null) {
            analiseError.setTipoFatorContribuinteProfissional("O fator contribuinte do profissional não pode ser vazio!");
        }

        if(analise.getTipoFatorContribuinteTrabalho() == null) {
            analiseError.setTipoFatorContribuinteTrabalho("O fator contribuinte do trabalho não pode ser vazio!");
        }

        if(analise.getTipoFatorAtenuanteAgente() == null) {
            analiseError.setTipoFatorAtenuanteAgente("O fator atenuante do agente não pode ser vazio!");
        }

        if(analise.getTipoFatorAtenuanteOrganizacao() == null) {
            analiseError.setTipoFatorAtenuanteOrganizacao("O fator atenuante da organização não pode ser vazio!");
        }

        if(analise.getTipoFatorAtenuantePaciente() == null) {
            analiseError.setTipoFatorAtenuantePaciente("O fator atenuante do paciente não pode ser vazio!");
        }

        if(analise.getTipoFatorAtenuanteProfissional() == null) {
            analiseError.setTipoFatorAtenuanteProfissional("O fator atenuante profissional não pode ser vazio!");
        }

        return analiseError;
    }
}
