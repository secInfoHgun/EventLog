package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.controller.validators.utils.HoraValidator;
import com.hgun.sti.models.Obito;
import com.hgun.sti.models.errors.ObitoError;

public class ObitoValidator {
    public static ObitoError validarObito(Obito obito){

        var obitoError = new ObitoError();

        if(obito.getNumeroDaDeclaracao() == null || obito.getNumeroDaDeclaracao().isEmpty()){
            obitoError.setNumeroDaDeclaracao("O número da declaração de óbito não pode estar vazio!");
        }else if(!obito.getNumeroDaDeclaracao().matches("^[\\$]?[-+]?[\\d\\.,]*[\\.,]?\\d+$")){
            obitoError.setNumeroDaDeclaracao("O número da declaração de óbito deve conter apenas números!");
        }else if(obito.getNumeroDaDeclaracao().length() < 4){
            obitoError.setNumeroDaDeclaracao("O número da declaração de óbito está muito curto! (min: 4 caracteres)");
        }

        if(obito.getCausaDaMorte() == null || obito.getCausaDaMorte().isEmpty()){
            obitoError.setCausaDaMorte("A causa da morte não pode estar vazia!");
        }else if(obito.getCausaDaMorte().length() < 15){
            obitoError.setCausaDaMorte("A causa da morte está muito curta! (min: 15 caracteres)");
        }

        if(obito.getTipoLesao() == null){
            obitoError.setTipoLesao("O tipo de lesão não pode ser vazio!");
        }

        obitoError.setDataDoObito(DataValidator.validarData(obito.getDataDoObito()));

        return obitoError;
    }
}
