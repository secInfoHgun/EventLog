package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OcorrenciaError {

    public PacienteError paciente;

    public String resumo;

    public String descricao;

    public String diagnostico;

    public String fatorContribuinte;

    public String dataDaOcorrencia;

    public String horaDaOcorrencia;

    public String dataDaInternacao;

    public String horaDaInternacao;

    public String tipoOcorrencia;

    public String tipoIncidencia;

    public String tipoDano;

    public String tipoSetor;

    public String tipoFaseAssistencia;

    public String tipoIdentificacao;

    public String tipoIdentificador;

    public boolean isEmpty(){
        if(!paciente.isEmpty()){
            return false;
        }else if(resumo != null && !resumo.isEmpty()){
            return false;
        }else if(descricao != null && !descricao.isEmpty()){
            return false;
        }else if(diagnostico != null && !diagnostico.isEmpty()){
            return false;
        }else if(dataDaOcorrencia != null && !dataDaOcorrencia.isEmpty()){
            return false;
        }else if(horaDaOcorrencia != null && !horaDaOcorrencia.isEmpty()){
            return false;
        }else if(dataDaInternacao != null && !dataDaInternacao.isEmpty()){
            return false;
        }else if(horaDaInternacao != null && !horaDaInternacao.isEmpty()){
            return false;
        }else if(tipoOcorrencia != null && !tipoOcorrencia.isEmpty()){
            return false;
        }else if(tipoIncidencia != null && !tipoIncidencia.isEmpty()){
            return false;
        }else if(tipoDano != null && !tipoDano.isEmpty()){
            return false;
        }else if(tipoSetor != null && !tipoSetor.isEmpty()){
            return false;
        }else if(tipoFaseAssistencia != null && !tipoFaseAssistencia.isEmpty()){
            return false;
        }else if(fatorContribuinte != null && !fatorContribuinte.isEmpty()){
            return false;
        }else if(tipoIdentificacao != null && !tipoIdentificacao.isEmpty()){
            return false;
        }else if(tipoIdentificador != null && !tipoIdentificador.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
