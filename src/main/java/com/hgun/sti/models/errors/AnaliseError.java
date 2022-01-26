package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnaliseError {

    String tipoConsequenciaOrganizacional;

    String tipoFatorContribuinteCognitivo;

    String tipoFatorContribuinteComportamento;

    String tipoFatorContribuinteComunicacao;

    String tipoFatorContribuinteDesenpenho;

    String tipoFatorContribuinteOrganizacional;

    String tipoFatorContribuintePaciente;

    String tipoFatorContribuinteProfissional;

    String tipoFatorContribuinteTrabalho;

    String tipoFatorAtenuanteAgente;

    String tipoFatorAtenuanteOrganizacao;

    String tipoFatorAtenuantePaciente;

    String tipoFatorAtenuanteProfissional;

    public boolean isEmpty(){
        if( tipoConsequenciaOrganizacional != null && !tipoConsequenciaOrganizacional.isEmpty()){
            return false;
        }else if(tipoFatorContribuinteCognitivo != null && !tipoFatorContribuinteCognitivo.isEmpty()){
            return false;
        }else if(tipoFatorContribuinteComportamento != null && !tipoFatorContribuinteComportamento.isEmpty()){
            return false;
        }else if(tipoFatorContribuinteComunicacao != null && !tipoFatorContribuinteComunicacao.isEmpty()){
            return false;
        }else if(tipoFatorContribuinteDesenpenho != null && !tipoFatorContribuinteDesenpenho.isEmpty()){
            return false;
        }else if(tipoFatorContribuinteOrganizacional != null && !tipoFatorContribuinteOrganizacional.isEmpty()){
            return false;
        }else if(tipoFatorContribuintePaciente != null && !tipoFatorContribuintePaciente.isEmpty()){
            return false;
        }else if(tipoFatorContribuinteProfissional != null && !tipoFatorContribuinteProfissional.isEmpty()){
            return false;
        }else if(tipoFatorContribuinteTrabalho != null && !tipoFatorContribuinteTrabalho.isEmpty()){
            return false;
        }else if(tipoFatorAtenuanteAgente != null && !tipoFatorAtenuanteAgente.isEmpty()){
            return false;
        }else if(tipoFatorAtenuanteOrganizacao != null && !tipoFatorAtenuanteOrganizacao.isEmpty()){
            return false;
        }else if(tipoFatorAtenuantePaciente != null && !tipoFatorAtenuantePaciente.isEmpty()){
            return false;
        }else if(tipoFatorAtenuanteProfissional != null && !tipoFatorAtenuanteProfissional.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
