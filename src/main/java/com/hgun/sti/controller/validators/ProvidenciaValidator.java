package com.hgun.sti.controller.validators;

import com.hgun.sti.models.Providencia;
import com.hgun.sti.models.errors.ProvidenciaError;

public class ProvidenciaValidator {
    public static ProvidenciaError validarProvidencia(Providencia providencia){

        var providenciaError = new ProvidenciaError();

        if(providencia.getTipoAcaoMelhoriaPaciente() == null) {
            providenciaError.setTipoAcaoMelhoriaPaciente("A ação de melhoria focada no paciente não pode ser vazia!");
        }

        if(providencia.getTipoAcaoMelhoriaOrganizacao() == null) {
            providenciaError.setTipoAcaoMelhoriaOrganizacao("A ação de melhoria focada na organização não pode ser vazia!");
        }

        if(providencia.getTipoAcaoReduzirRiscoPaciente() == null) {
            providenciaError.setTipoAcaoReduzirRiscoPaciente("A ação de redução de riscos focada no paciente não pode ser vazia!");
        }

        if(providencia.getTipoAcaoReduzirRiscoProfissional() == null) {
            providenciaError.setTipoAcaoReduzirRiscoProfissional("A ação de redução de riscos focada no profissional não pode ser vazia!");
        }

        if(providencia.getTipoAcaoReduzirRiscoOrganizacional() == null) {
            providenciaError.setTipoAcaoReduzirRiscoOrganizacional("A ação de redução de riscos focada no ambiental / organizacional não pode ser vazia!");
        }

        if(providencia.getOutrasProvidencias() != null && !providencia.getOutrasProvidencias().isEmpty()){
            if(providencia.getOutrasProvidencias().length() < 4){
                providenciaError.setOutrasProvidencias("As outras providências estão muito curtas! (min: 4 caracteres)");
            }
        }

        return providenciaError;
    }

}
