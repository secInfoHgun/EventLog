package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.errors.OcorrenciaError;

import java.time.LocalDateTime;

public class OcorrenciaValidator {
    public static OcorrenciaError validarOcorrencia(Ocorrencia ocorrencia){

        var ocorrenciaError = new OcorrenciaError();

        ocorrenciaError.setPaciente(PacienteValidator.validarPaciente(ocorrencia.getPaciente()));

        if(ocorrencia.getTipoSetor() == null){
            ocorrenciaError.setTipoSetor("O setor não pode ser vazio!");
        }

        ocorrenciaError.setData(validaData(ocorrencia.getData()));

        ocorrenciaError.setHora(validaHora(ocorrencia.getHora()));

        if(ocorrencia.getResumo() == null || ocorrencia.getResumo().isEmpty()){
            ocorrenciaError.setResumo("O resumo da ocorrência não pode ser vazio!");
        }else if(ocorrencia.getResumo().length() < 15){
            ocorrenciaError.setResumo("O resumo da ocorrência está muito curto! (min: 15 caracteres)");
        }

        if(ocorrencia.getTipoOcorrencia() == null){
            ocorrenciaError.setTipoOcorrencia("O tipo de ocorrência não pode ser vazio!");
        }

        if(ocorrencia.getTipoFaseAssistencia() == null){
            ocorrenciaError.setTipoFaseAssistencia("A fase de assistência não pode ser vazia!");
        }

        if(ocorrencia.getTipoIncidencia() == null){
            ocorrenciaError.setTipoIncidencia("O tipo de incidência não pode ser vazio!");
        }

        if(ocorrencia.getTipoDano() == null){
            ocorrenciaError.setTipoDano("O grau de dano não pode ser vazio!");
        }

        if(ocorrencia.getDescricao() == null || ocorrencia.getDescricao().isEmpty()){
            ocorrenciaError.setDescricao("A descrição da ocorrência não pode ser vazia!");
        }else if(ocorrencia.getDescricao().length() < 15){
            ocorrenciaError.setDescricao("A descrição da ocorrência está muito curta! (min: 15 caracteres)");
        }

        if(ocorrencia.getFatorContribuinte() != null && !ocorrencia.getFatorContribuinte().isEmpty()){
            if(ocorrencia.getFatorContribuinte().length() < 15){
                ocorrenciaError.setFatorContribuinte("O fator contribuinte está muito curto! (min: 15 caracteres)");
            }else if(ocorrencia.getFatorContribuinte().matches("^[0-9]")){
                ocorrenciaError.setFatorContribuinte("O fator contribuinte está inválido!");
            }
        }

        return ocorrenciaError;
    }

    public static String validaData(String data){
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

    public static String validaHora(String hora){
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
