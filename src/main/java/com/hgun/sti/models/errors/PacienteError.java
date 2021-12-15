package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteError {

    public String prontuario;

    public String nome;

    public String idade;

    public String sexo;

    public boolean isEmpty(){
        if(prontuario != null && !prontuario.isEmpty()){
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
