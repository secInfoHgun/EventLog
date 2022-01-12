package com.hgun.sti.controller.validators.utils;

public class HoraValidator {
    public static String validarHora(String hora){

        if(hora == null || hora.isEmpty()){
            return "A data não pode ser vazia!";
        }

        var hh = Integer.parseInt(hora.split(":")[0]);
        var mm = Integer.parseInt(hora.split(":")[1]);

        if(hh > 23 || hh < 0 || mm > 59 || mm < 0){
            return "A hora não é válida!";
        }

        return null;
    }
}
