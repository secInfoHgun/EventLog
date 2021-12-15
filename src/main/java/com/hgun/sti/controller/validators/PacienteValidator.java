package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Paciente;
import com.hgun.sti.models.errors.PacienteError;

public class PacienteValidator {
    public static PacienteError validarPaciente(Paciente paciente){

        var pacienteError = new PacienteError();

        if(paciente.getNome() == null || paciente.getNome().isEmpty()){
            pacienteError.setNome("O nome não pode estar vazio!");
        }else if(paciente.getNome().length() < 4){
            pacienteError.setNome("O nome do paciente está muito curto! (min: 4 letras)");
        }else if(!paciente.getNome().matches("[a-zA-Z\s]+")){
            pacienteError.setNome("O nome do paciente deve conter apenas letras e espaços");
        }

        if(paciente.getProntuario() == null || paciente.getProntuario().isEmpty()){
            pacienteError.setProntuario("O prontuário não pode estar vazio!");
        }else if(!paciente.getProntuario().matches("^[0-9]")){
            pacienteError.setProntuario("O prontuário deve conter apenas números!");
        }

        if(paciente.getIdade() == null || paciente.getIdade().isEmpty()){
            pacienteError.setIdade("A idade não pode estar vazia!");
        }else if(paciente.getIdade().equals("00 ano(s) 00 mes(s)")){
            pacienteError.setIdade("A idade é inválida!");
        }

        if(paciente.getSexo() == null || paciente.getSexo().equals("") || paciente.getSexo().equals(" ")){
            pacienteError.setSexo("O sexo é inválido!");
        }

        return pacienteError;
    }
}
