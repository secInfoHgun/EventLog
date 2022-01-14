package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProvidenciaError {

    public String acoesDeMelhoria;

    public String acoesParaReduzirRiscos;

    public String fatoresAtenuantesDaOcorrencia;

    public String data;

    public boolean isEmpty(){
        if(acoesDeMelhoria != null && !acoesDeMelhoria.isEmpty()){
            return false;
        }else if(acoesParaReduzirRiscos != null && !acoesParaReduzirRiscos.isEmpty()){
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