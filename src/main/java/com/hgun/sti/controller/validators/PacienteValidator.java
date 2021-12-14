package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Paciente;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class PacienteValidator {
    public static BindingResult validarPaciente(Paciente paciente, BindingResult erros){

        if(paciente.getNome() == null || paciente.getNome().isEmpty()){
            erros.addError(new ObjectError("nome", "O nome não pode estar vazio!"));
        }else if(paciente.getNome().length() < 4){
            erros.addError(new ObjectError("nome", "O nome do paciente está muito curto! (min: 4 letras)"));
        }else if(!paciente.getNome().matches("[a-zA-Z\s]+")){
            erros.addError(new ObjectError("nome", "O nome do paciente deve conter apenas letras e espaços"));
        }

        if(paciente.getProntuario() == null || paciente.getProntuario().isEmpty()){
            erros.addError(new ObjectError("prontuario", "O prontuário não pode estar vazio!"));
        }else if(!paciente.getProntuario().matches("^[0-9]")){
            erros.addError(new ObjectError("prontuario", "O prontuário deve conter apenas números!"));
        }

        if(paciente.getIdade() == null || paciente.getIdade().isEmpty()){
            erros.addError(new ObjectError("idade", "A idade não pode estar vazia!"));
        }else if(paciente.getIdade().equals("00 ano(s) 00 mes(s)")){
            erros.addError(new ObjectError("idade", "A idade é inválida!"));
        }

        if(paciente.getSexo() == null || paciente.getSexo().equals("") || paciente.getSexo().equals(" ")){
            erros.addError(new ObjectError("sexo", "O sexo é inválido!"));
        }

        return erros;
    }
}
