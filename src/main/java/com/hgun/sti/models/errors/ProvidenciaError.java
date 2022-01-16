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

    public String outrasProvidencias;

    public boolean isEmpty(){
        if(acoesDeMelhoria != null && !acoesDeMelhoria.isEmpty()){
            return false;
        }else if(acoesParaReduzirRiscos != null && !acoesParaReduzirRiscos.isEmpty()){
            return false;
        }else if(outrasProvidencias != null && !outrasProvidencias.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
