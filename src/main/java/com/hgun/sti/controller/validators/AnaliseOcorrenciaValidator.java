package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.models.AnaliseOcorrencia;
import com.hgun.sti.models.errors.AnaliseOcorrenciaError;

public class AnaliseOcorrenciaValidator {
    public static AnaliseOcorrenciaError validarAnaliseOcorrencia(AnaliseOcorrencia analiseOcorrencia){

        var analiseOcorrenciaError = new AnaliseOcorrenciaError();

        if(analiseOcorrencia.getFatoresContribuintes() == null || analiseOcorrencia.getFatoresContribuintes().isEmpty()){
            analiseOcorrenciaError.setFatoresContribuintes("O fator contribuinte não pode estar vazio!");
        }else if(analiseOcorrencia.getFatoresContribuintes().length() < 15){
            analiseOcorrenciaError.setFatoresContribuintes("O fator contribuinte está muito curto! (min: 15 caracteres)");
        }

        if(analiseOcorrencia.getConsequenciasOrganizacionais() == null || analiseOcorrencia.getConsequenciasOrganizacionais().isEmpty()){
            analiseOcorrenciaError.setConsequenciasOrganizacionais("A consequência organizacional não pode estar vazia!");
        }else if(analiseOcorrencia.getConsequenciasOrganizacionais().length() < 15){
            analiseOcorrenciaError.setConsequenciasOrganizacionais("A consequência organizacional está muito curta! (min: 15 caracteres)");
        }

        if(analiseOcorrencia.getIdentificacaoeAnaliseDeFatores() == null || analiseOcorrencia.getIdentificacaoeAnaliseDeFatores().isEmpty()){
            analiseOcorrenciaError.setIdentificacaoeAnaliseDeFatores("A análise dos fatores não pode estar vazia!");
        }else if(analiseOcorrencia.getIdentificacaoeAnaliseDeFatores().length() < 15){
            analiseOcorrenciaError.setIdentificacaoeAnaliseDeFatores("A análise dos fatores está muito curta! (min: 15 caracteres)");
        }

        if(analiseOcorrencia.getFatoresAtenuantesDaOcorrencia() == null || analiseOcorrencia.getFatoresAtenuantesDaOcorrencia().isEmpty()){
            analiseOcorrenciaError.setFatoresAtenuantesDaOcorrencia("O fator atenuante não pode estar vazio!");
        }else if(analiseOcorrencia.getFatoresAtenuantesDaOcorrencia().length() < 15){
            analiseOcorrenciaError.setFatoresAtenuantesDaOcorrencia("O fator atenuante está muito curto! (min: 15 caracteres)");
        }

        analiseOcorrenciaError.setData(DataValidator.validarData(analiseOcorrencia.getData()));

        return analiseOcorrenciaError;
    }
}
