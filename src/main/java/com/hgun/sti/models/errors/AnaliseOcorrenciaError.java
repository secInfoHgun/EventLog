package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnaliseOcorrenciaError {

    public String fatoresContribuintes;

    public String consequenciasOrganizacionais;

    public String identificacaoeAnaliseDeFatores;

    public String fatoresAtenuantesDaOcorrencia;

    public String data;

    public boolean isEmpty(){
        if(fatoresContribuintes != null && !fatoresContribuintes.isEmpty()){
            return false;
        }else if(consequenciasOrganizacionais != null && !consequenciasOrganizacionais.isEmpty()){
            return false;
        }else if(identificacaoeAnaliseDeFatores != null && !identificacaoeAnaliseDeFatores.isEmpty()){
            return false;
        }else if(fatoresAtenuantesDaOcorrencia != null && !fatoresAtenuantesDaOcorrencia.isEmpty()){
            return false;
        }else if(data != null && !data.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
