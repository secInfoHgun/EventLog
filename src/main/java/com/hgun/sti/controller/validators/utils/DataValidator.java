package com.hgun.sti.controller.validators.utils;

import java.time.LocalDateTime;

public class DataValidator {
    public static String validarData(String data){

        if(data == null || data.isEmpty()){
            return "A data não pode ser vazia!";
        }

        var diaform = Integer.parseInt(data.split("/")[0]);
        var mesform = Integer.parseInt(data.split("/")[1]);
        var anoform = Integer.parseInt(data.split("/")[2]);

        if(mesform > 12 || mesform < 1){
            return "A data não é válida!";
        }

        if((mesform == 1 || mesform == 3 || mesform == 5 || mesform == 7 || mesform == 8 || mesform == 10 || mesform == 12) && (diaform > 31 || diaform < 1)){
            return "A data não é válida!";
        }

        if((mesform == 4 || mesform == 6 || mesform == 9 || mesform == 11) && (diaform > 30 || diaform < 1)){
            return "A data não é válida!";
        }

        if(mesform == 2){
            if((anoform % 400 == 0) || ((anoform % 4 == 0) && (anoform % 100 != 0))){
                if(diaform > 29 || diaform < 1){
                    return "A data não é válida!";
                }
            }else {
                if(diaform > 28 || diaform < 1){
                    return "A data não é válida!";
                }
            }
        }

        var anoatual = LocalDateTime.now().getYear();

        if(anoform < (anoatual-5)){
            return "A data mínima é de até 5 anos antes do ano atual!";
        }else if(anoform > anoatual){
            return "A data máxima é o ano atual!";
        }

        return null;
    }
}

