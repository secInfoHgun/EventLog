package com.hgun.sti.models;

import com.hgun.sti.models.types.TipoConsequenciaOrganizacional;
import com.hgun.sti.models.types.fator.contribuinte.*;
import com.hgun.sti.models.types.fator.atenuante.*;
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
@Table(name="analises")
public class Analise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    private TipoConsequenciaOrganizacional tipoConsequenciaOrganizacional;

    @OneToOne
    private TipoFatorContribuinteCognitivo tipoFatorContribuinteCognitivo;

    @OneToOne
    private TipoFatorContribuinteComportamento tipoFatorContribuinteComportamento;

    @OneToOne
    private TipoFatorContribuinteComunicacao tipoFatorContribuinteComunicacao;

    @OneToOne
    private TipoFatorContribuinteDesenpenho tipoFatorContribuinteDesenpenho;

    @OneToOne
    private TipoFatorContribuinteOrganizacional tipoFatorContribuinteOrganizacional;

    @OneToOne
    private TipoFatorContribuintePaciente tipoFatorContribuintePaciente;

    @OneToOne
    private TipoFatorContribuinteProfissional tipoFatorContribuinteProfissional;

    @OneToOne
    private TipoFatorContribuinteTrabalho tipoFatorContribuinteTrabalho;

    @OneToOne
    private TipoFatorAtenuanteAgente tipoFatorAtenuanteAgente;

    @OneToOne
    private TipoFatorAtenuanteOrganizacao tipoFatorAtenuanteOrganizacao;

    @OneToOne
    private TipoFatorAtenuantePaciente tipoFatorAtenuantePaciente;

    @OneToOne
    private TipoFatorAtenuanteProfissional tipoFatorAtenuanteProfissional;

    @NotBlank
    public String data;

    @NotBlank
    public String hora;

    @OneToOne
    public Ocorrencia ocorrencia;
}
