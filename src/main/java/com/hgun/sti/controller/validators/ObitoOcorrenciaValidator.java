package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.models.ObitoOcorrencia;
import com.hgun.sti.models.errors.ObitoOcorrenciaError;

public class ObitoOcorrenciaValidator {
    public static ObitoOcorrenciaError validarObitoOcorrencia(ObitoOcorrencia obitoOcorrencia){

        var obitoOcorrenciaError = new ObitoOcorrenciaError();

        if(obitoOcorrencia.getNumeroDaDeclaracao() == null || obitoOcorrencia.getNumeroDaDeclaracao().isEmpty()){
            obitoOcorrenciaError.setNumeroDaDeclaracao("O número da declaração de óbito não pode estar vazio!");
        }else if(!obitoOcorrencia.getNumeroDaDeclaracao().matches("^[\\$]?[-+]?[\\d\\.,]*[\\.,]?\\d+$")){
            obitoOcorrenciaError.setNumeroDaDeclaracao("O número da declaração de óbito deve conter apenas números!");
        }else if(obitoOcorrencia.getNumeroDaDeclaracao().length() < 4){
            obitoOcorrenciaError.setNumeroDaDeclaracao("O número da declaração de óbito está muito curto! (min: 4 caracteres)");
        }

        if(obitoOcorrencia.getCausaDaMorte() == null || obitoOcorrencia.getCausaDaMorte().isEmpty()){
            obitoOcorrenciaError.setCausaDaMorte("A causa da morte não pode estar vazia!");
        }else if(obitoOcorrencia.getCausaDaMorte().length() < 15){
            obitoOcorrenciaError.setCausaDaMorte("A causa da morte está muito curta! (min: 15 caracteres)");
        }

        if(obitoOcorrencia.getTipoLesao() == null){
            obitoOcorrenciaError.setTipoLesao("O tipo de lesão não pode ser vazio!");
        }

        obitoOcorrenciaError.setDataDoObito(DataValidator.validarData(obitoOcorrencia.getDataDoObito()));

        obitoOcorrenciaError.setData(DataValidator.validarData(obitoOcorrencia.getData()));

        return obitoOcorrenciaError;
    }
}
