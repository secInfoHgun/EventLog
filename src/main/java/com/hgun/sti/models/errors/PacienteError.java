package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteError {

    public String preccp;

    public String nome;

    public String idade;

    public String sexo;

    public boolean isEmpty(){
        if(preccp != null && !preccp.isEmpty()){
            return false;
        }else if(nome != null && !nome.isEmpty()){
            return false;
        }else if(idade != null && !idade.isEmpty()){
            return false;
        }else if(sexo != null && !sexo.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
