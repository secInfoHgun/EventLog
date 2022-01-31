package com.hgun.sti.models.errors;

import com.hgun.sti.models.types.acao.melhoria.TipoAcaoMelhoriaOrganizacao;
import com.hgun.sti.models.types.acao.melhoria.TipoAcaoMelhoriaPaciente;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoOrganizacional;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoPaciente;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoProfissional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProvidenciaError {

    public String tipoAcaoMelhoriaPaciente;

    public String tipoAcaoMelhoriaOrganizacao;

    public String tipoAcaoReduzirRiscoPaciente;

    public String tipoAcaoReduzirRiscoProfissional;

    public String tipoAcaoReduzirRiscoOrganizacional;

    public String outrasProvidencias;

    public boolean isEmpty(){
        if(tipoAcaoMelhoriaPaciente != null && !tipoAcaoMelhoriaPaciente.isEmpty()){
            return false;
        }else if(tipoAcaoMelhoriaOrganizacao != null && !tipoAcaoMelhoriaOrganizacao.isEmpty()){
            return false;
        }else if(tipoAcaoReduzirRiscoPaciente != null && !tipoAcaoReduzirRiscoPaciente.isEmpty()){
            return false;
        }else if(tipoAcaoReduzirRiscoProfissional != null && !tipoAcaoReduzirRiscoProfissional.isEmpty()){
            return false;
        }else if(tipoAcaoReduzirRiscoOrganizacional != null && !tipoAcaoReduzirRiscoOrganizacional.isEmpty()){
            return false;
        }else if(outrasProvidencias != null && !outrasProvidencias.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
