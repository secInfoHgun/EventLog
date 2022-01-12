package com.hgun.sti.models.errors;

import com.hgun.sti.models.types.TipoLesao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObitoOcorrenciaError {

    public String dataDoObito;

    public String numeroDaDeclaracao;

    public String tipoLesao;

    public String causaDaMorte;

    public String data;

    public boolean isEmpty(){
        if(dataDoObito != null && !dataDoObito.isEmpty()){
            return false;
        }else if(numeroDaDeclaracao != null && !numeroDaDeclaracao.isEmpty()){
            return false;
        }else if(tipoLesao != null && !tipoLesao.isEmpty()){
            return false;
        }else if(causaDaMorte != null && !causaDaMorte.isEmpty()){
            return false;
        }else if(data != null && !data.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
