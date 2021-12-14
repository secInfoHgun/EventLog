package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Ocorrencia;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class OcorrenciaValidator {
    public static BindingResult validarOcorrencia(Ocorrencia ocorrencia, BindingResult erros){

        if(ocorrencia.getPaciente() == null){
            erros.addError(new ObjectError("paciente", "O paciente das ocorrências não pode estar vazio!"));
        }else{
            erros = PacienteValidator.validarPaciente(ocorrencia.getPaciente(), erros);
        }

        if(ocorrencia.getTipoSetor() == null){
            erros.addError(new ObjectError("setor", "O setor não pode ser vazio!"));
        }

        //data

        //hora

        if(ocorrencia.getResumo() == null || ocorrencia.getResumo().isEmpty()){
            erros.addError(new ObjectError("resumo", "O resumo da ocorrência não pode ser vazio!"));
        }

        if(ocorrencia.getTipoOcorrencia() == null){
            erros.addError(new ObjectError("ocorrencia", "O tipo de ocorrência não pode ser vazio!"));
        }

        if(ocorrencia.getTipoFaseAssistencia() == null){
            erros.addError(new ObjectError("faseAssistencia", "A fase de assistência não pode ser vazia!"));
        }

        if(ocorrencia.getTipoIncidencia() == null){
            erros.addError(new ObjectError("incidencia", "O tipo de incidência não pode ser vazio!"));
        }

        if(ocorrencia.getTipoDano() == null){
            erros.addError(new ObjectError("dano", "O grau de dano não pode ser vazio!"));
        }

        if(ocorrencia.getDescricao() == null || ocorrencia.getDescricao().isEmpty()){
            erros.addError(new ObjectError("descricao", "A descrição da ocorrência não pode ser vazia!"));
        }

        return erros;
    }
}
