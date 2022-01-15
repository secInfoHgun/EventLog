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

    public String data;

    public String hora;

    public boolean isEmpty(){
        if(acoesDeMelhoria != null && !acoesDeMelhoria.isEmpty()){
            return false;
        }else if(acoesParaReduzirRiscos != null && !acoesParaReduzirRiscos.isEmpty()){
            return false;
        }else if(outrasProvidencias != null && !outrasProvidencias.isEmpty()){
            return false;
        }else if(data != null && !data.isEmpty()){
            return false;
        }else if(hora != null && !hora.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
