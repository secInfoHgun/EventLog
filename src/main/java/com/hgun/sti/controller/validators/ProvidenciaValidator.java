package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.controller.validators.utils.HoraValidator;
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

        if(providencia.getOutrasProvidencias() != null && !providencia.getOutrasProvidencias().isEmpty()){
            if(providencia.getOutrasProvidencias().length() < 4){
                providenciaError.setOutrasProvidencias("As outras providências estão muito curtas! (min: 4 caracteres)");
            }
        }

        providenciaError.setData(DataValidator.validarData(providencia.getData()));

        providenciaError.setHora(HoraValidator.validarHora(providencia.getHora()));

        return providenciaError;
    }

}
