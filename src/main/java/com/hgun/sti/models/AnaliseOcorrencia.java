package com.hgun.sti.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name="analises_ocorrencias")
public class AnaliseOcorrencia {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    public String fatoresContribuintes;

    @NotBlank
    public String consequenciasOrganizacionais;

    @NotBlank
    public String identificacaoeAnaliseDeFatores;

    @NotBlank
    public String fatoresAtenuantesDaOcorrencia;

    @NotBlank
    public String data;
}
