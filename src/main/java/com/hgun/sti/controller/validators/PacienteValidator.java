package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Paciente;
import com.hgun.sti.models.errors.PacienteError;

public class PacienteValidator {
    public static PacienteError validarPaciente(Paciente paciente){

        var pacienteError = new PacienteError();

        if(paciente.getNome() != null && !paciente.getNome().isEmpty() && !paciente.getNome().equals("")){
            if(paciente.getNome().length() < 4){
                pacienteError.setNome("O nome do paciente está muito curto! (min: 4 caracteres)");
            }else if(!paciente.getNome().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}")){
                pacienteError.setNome("O nome do paciente deve conter apenas letras e espaços");
            }
        }

        if(paciente.preccp != null && !paciente.preccp.isEmpty() && !paciente.preccp.equals("") ){
            if(!paciente.getPreccp().matches("^[\\$]?[-+]?[\\d\\.,]*[\\.,]?\\d+$")){
                pacienteError.setPreccp("O PRECCP deve conter apenas números!");
            }
        }

        if(paciente.getIdade() != null && !paciente.getIdade().isEmpty() && !paciente.getIdade().equals("") ){
            pacienteError.setIdade(validaIdade(paciente.getIdade()));
        }

        return pacienteError;
    }

    public static String validaIdade(String idade){
        if(idade == null || idade.isEmpty()){
            return "A idade não pode ser vazia!";
        }

        var anos = Integer.parseInt(idade.split(" ")[0]);

        if(idade.equals("00 ano(s)") || anos < 0){
            return "A idade é inválida!";
        }

        return null;
    }
}
