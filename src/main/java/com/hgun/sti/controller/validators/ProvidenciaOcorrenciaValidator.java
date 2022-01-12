package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.models.ProvidenciaOcorrencia;
import com.hgun.sti.models.errors.ProvidenciaOcorrenciaError;

public class ProvidenciaOcorrenciaValidator {
    public static ProvidenciaOcorrenciaError validarProvidenciaOcorrencia(ProvidenciaOcorrencia providenciaOcorrencia){

        var providenciaOcorrenciaError = new ProvidenciaOcorrenciaError();

        // verificar com a CAP se as providencias são obrigatóroias ou facultativas,
        // visto que existe uma opção de declarar que tal situação náo caracteriza um evento adverso

        // acoesDeMelhoria;
        // acoesParaReduzirRiscos;
        // fatoresAtenuantesDaOcorrencia;

        //        if(ocorrencia.getFatorContribuinte() != null && !ocorrencia.getFatorContribuinte().isEmpty()){
        //            if(ocorrencia.getFatorContribuinte().length() < 15){
        //                ocorrenciaError.setFatorContribuinte("O fator contribuinte está muito curto! (min: 15 caracteres)");
        //            }else if(ocorrencia.getFatorContribuinte().matches("^[0-9]")){
        //                ocorrenciaError.setFatorContribuinte("O fator contribuinte está inválido!");
        //            }
        //        }

        providenciaOcorrenciaError.setData(DataValidator.validarData(providenciaOcorrencia.getData()));

        return providenciaOcorrenciaError;
    }

}
