package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.controller.validators.utils.HoraValidator;
import com.hgun.sti.models.Analise;
import com.hgun.sti.models.errors.AnaliseError;

public class AnaliseValidator {
    public static AnaliseError validarAnalise(Analise analise){

        var analiseError = new AnaliseError();

        if(analise.getFatoresContribuintes() == null || analise.getFatoresContribuintes().isEmpty()){
            analiseError.setFatoresContribuintes("O fator contribuinte não pode estar vazio!");
        }else if(analise.getFatoresContribuintes().length() < 15){
            analiseError.setFatoresContribuintes("O fator contribuinte está muito curto! (min: 15 caracteres)");
        }

        if(analise.getConsequenciasOrganizacionais() == null || analise.getConsequenciasOrganizacionais().isEmpty()){
            analiseError.setConsequenciasOrganizacionais("A consequência organizacional não pode estar vazia!");
        }else if(analise.getConsequenciasOrganizacionais().length() < 15){
            analiseError.setConsequenciasOrganizacionais("A consequência organizacional está muito curta! (min: 15 caracteres)");
        }

        if(analise.getIdentificacaoeAnaliseDeFatores() == null || analise.getIdentificacaoeAnaliseDeFatores().isEmpty()){
            analiseError.setIdentificacaoeAnaliseDeFatores("A análise dos fatores não pode estar vazia!");
        }else if(analise.getIdentificacaoeAnaliseDeFatores().length() < 15){
            analiseError.setIdentificacaoeAnaliseDeFatores("A análise dos fatores está muito curta! (min: 15 caracteres)");
        }

        if(analise.getFatoresAtenuantesDaOcorrencia() == null || analise.getFatoresAtenuantesDaOcorrencia().isEmpty()){
            analiseError.setFatoresAtenuantesDaOcorrencia("O fator atenuante não pode estar vazio!");
        }else if(analise.getFatoresAtenuantesDaOcorrencia().length() < 15){
            analiseError.setFatoresAtenuantesDaOcorrencia("O fator atenuante está muito curto! (min: 15 caracteres)");
        }

        return analiseError;
    }
}
