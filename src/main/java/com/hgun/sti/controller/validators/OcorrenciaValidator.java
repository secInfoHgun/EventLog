package com.hgun.sti.controller.validators;

import com.hgun.sti.controller.validators.utils.DataValidator;
import com.hgun.sti.controller.validators.utils.HoraValidator;
import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.errors.OcorrenciaError;

public class OcorrenciaValidator {
    public static OcorrenciaError validarOcorrencia(Ocorrencia ocorrencia){

        var ocorrenciaError = new OcorrenciaError();

        ocorrenciaError.setPaciente(PacienteValidator.validarPaciente(ocorrencia.getPaciente()));

        if(ocorrencia.getTipoSetor() == null){
            ocorrenciaError.setTipoSetor("O setor não pode ser vazio!");
        }

        ocorrenciaError.setData(DataValidator.validarData(ocorrencia.getData()));

        ocorrenciaError.setHora(HoraValidator.validarHora(ocorrencia.getHora()));

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
}
