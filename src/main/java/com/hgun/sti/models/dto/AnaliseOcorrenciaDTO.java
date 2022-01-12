package com.hgun.sti.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnaliseOcorrenciaDTO {
    Long id;
    String fatoresContribuintes;
    String consequenciasOrganizacionais;
    String identificacaoeAnaliseDeFatores;
    String fatoresAtenuantesDaOcorrencia;
    String data;

}
