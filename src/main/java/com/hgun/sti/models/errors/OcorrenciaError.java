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

    public String fatorContribuinte;

    public String data;

    public String hora;

    public String tipoOcorrencia;

    public String tipoIncidencia;

    public String tipoDano;

    public String tipoSetor;

    public String tipoFaseAssistencia;

    public boolean isEmpty(){
        if(!paciente.isEmpty()){
            return false;
        }else if(resumo != null && !resumo.isEmpty()){
            return false;
        }else if(descricao != null && !descricao.isEmpty()){
            return false;
        }else if(data != null && !data.isEmpty()){
            return false;
        }else if(hora != null && !hora.isEmpty()){
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
        }else{
            return true;
        }
    }
}
