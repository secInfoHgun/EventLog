package com.hgun.sti.controller.utils;

import java.time.LocalDateTime;

public class FormatData {
    public static String formatarData(LocalDateTime data){

        String dataFormatada = new String();

        var dia = data.getDayOfMonth();
        var mes = data.getMonth().getValue();
        var ano = data.getYear();

        if(dia < 10){
            dataFormatada += "0" + dia;
        }
        dataFormatada += "/";

        if(mes < 10){
            dataFormatada += "0" + mes;
        }else{
            dataFormatada += mes;
        }

        dataFormatada += "/";
        dataFormatada += ano;

        return  dataFormatada;
    }
}
