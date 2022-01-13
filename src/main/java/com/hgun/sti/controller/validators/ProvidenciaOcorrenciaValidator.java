package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.models.ProvidenciaOcorrencia;
import com.hgun.sti.models.errors.ProvidenciaOcorrenciaError;

public class ProvidenciaOcorrenciaValidator {
    public static ProvidenciaOcorrenciaError validarProvidenciaOcorrencia(ProvidenciaOcorrencia providenciaOcorrencia){

        var providenciaOcorrenciaError = new ProvidenciaOcorrenciaError();

        if(providenciaOcorrencia.getAcoesDeMelhoria() != null && !providenciaOcorrencia.getAcoesDeMelhoria().isEmpty()){
            if(providenciaOcorrencia.getAcoesDeMelhoria().length() < 4){
                providenciaOcorrenciaError.setAcoesDeMelhoria("As ações de melhoria está muito curta! (min: 4 caracteres)");
            }
        }

        if(providenciaOcorrencia.getAcoesParaReduzirRiscos() != null && !providenciaOcorrencia.getAcoesParaReduzirRiscos().isEmpty()){
            if(providenciaOcorrencia.getAcoesParaReduzirRiscos().length() < 4){
                providenciaOcorrenciaError.setAcoesParaReduzirRiscos("As ações para reduzir riscos está muito curta! (min: 4 caracteres)");
            }
        }

        if(providenciaOcorrencia.getFatoresAtenuantesDaOcorrencia() != null && !providenciaOcorrencia.getFatoresAtenuantesDaOcorrencia().isEmpty()){
            if(providenciaOcorrencia.getFatoresAtenuantesDaOcorrencia().length() < 4){
                providenciaOcorrenciaError.setFatoresAtenuantesDaOcorrencia("Os fatores atenuantes da ocorrência está muito curto! (min: 4 caracteres)");
            }
        }

        providenciaOcorrenciaError.setData(DataValidator.validarData(providenciaOcorrencia.getData()));

        return providenciaOcorrenciaError;
    }

}
