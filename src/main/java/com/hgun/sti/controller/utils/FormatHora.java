package com.hgun.sti.controller.utils;

import java.time.LocalDateTime;

public class FormatHora {
    public static String formatarHora(LocalDateTime data){
        String horaFormatada = new String();

        var horas = data.getHour();
        var minutos = data.getMinute();

        if(horas < 10){
            horaFormatada += "0" + horas;
        }else{
            horaFormatada += horas;
        }

        horaFormatada += ":";

        if(minutos < 10){
            horaFormatada += "0" + minutos;
        }else{
            horaFormatada += minutos;
        }

        return  horaFormatada;
    }
}
