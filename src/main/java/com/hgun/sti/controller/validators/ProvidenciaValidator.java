package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Providencia;
import com.hgun.sti.models.errors.ProvidenciaError;

public class ProvidenciaValidator {
    public static ProvidenciaError validarProvidencia(Providencia providencia){

        var providenciaError = new ProvidenciaError();

        if(providencia.getOutrasProvidencias() != null && !providencia.getOutrasProvidencias().isEmpty()){
            if(providencia.getOutrasProvidencias().length() < 4){
                providenciaError.setOutrasProvidencias("As outras providências estão muito curtas! (min: 4 caracteres)");
            }
        }

        return providenciaError;
    }

}
