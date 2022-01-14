package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.models.Providencia;
import com.hgun.sti.models.errors.ProvidenciaError;

public class ProvidenciaValidator {
    public static ProvidenciaError validarProvidencia(Providencia providencia){

        var providenciaError = new ProvidenciaError();

        if(providencia.getAcoesDeMelhoria() != null && !providencia.getAcoesDeMelhoria().isEmpty()){
            if(providencia.getAcoesDeMelhoria().length() < 4){
                providenciaError.setAcoesDeMelhoria("As ações de melhoria está muito curta! (min: 4 caracteres)");
            }
        }

        if(providencia.getAcoesParaReduzirRiscos() != null && !providencia.getAcoesParaReduzirRiscos().isEmpty()){
            if(providencia.getAcoesParaReduzirRiscos().length() < 4){
                providenciaError.setAcoesParaReduzirRiscos("As ações para reduzir riscos está muito curta! (min: 4 caracteres)");
            }
        }

        if(providencia.getFatoresAtenuantesDaOcorrencia() != null && !providencia.getFatoresAtenuantesDaOcorrencia().isEmpty()){
            if(providencia.getFatoresAtenuantesDaOcorrencia().length() < 4){
                providenciaError.setFatoresAtenuantesDaOcorrencia("Os fatores atenuantes da ocorrência está muito curto! (min: 4 caracteres)");
            }
        }

        providenciaError.setData(DataValidator.validarData(providencia.getData()));

        return providenciaError;
    }

}
