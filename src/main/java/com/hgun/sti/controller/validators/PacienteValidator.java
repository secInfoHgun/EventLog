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
        }else if(!paciente.getNome().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}")){
            pacienteError.setNome("O nome do paciente deve conter apenas letras e espaços");
        }

        if(paciente.getPreccp() == null || paciente.getPreccp().isEmpty()){
            pacienteError.setPreccp("O PRECCP não pode estar vazio!");
        }else if(!paciente.getPreccp().matches("^[\\$]?[-+]?[\\d\\.,]*[\\.,]?\\d+$")){
            pacienteError.setPreccp("O PRECCP deve conter apenas números!");
        }

        pacienteError.setIdade(validaIdade(paciente.getIdade()));

        if(paciente.getSexo() == null || paciente.getSexo().equals("") || paciente.getSexo().equals(" ")){
            pacienteError.setSexo("O sexo é inválido!");
        }

        return pacienteError;
    }

    public static String validaIdade(String idade){
        if(idade == null || idade.isEmpty()){
            return "A idade não pode ser vazia!";
        }

        var anos = Integer.parseInt(idade.split(" ")[0]);
        var meses = Integer.parseInt(idade.split(" ")[2]);

        if(idade.equals("00 ano(s) 00 mes(s)") || anos < 0 || meses > 11 || meses < 0){
            return "A idade é inválida!";
        }

        return null;
    }
}
