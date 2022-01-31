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
    public TipoConsequenciaOrganizacional tipoConsequenciaOrganizacional;

    @OneToOne
    public TipoFatorContribuinteCognitivo tipoFatorContribuinteCognitivo;

    @OneToOne
    public TipoFatorContribuinteComportamento tipoFatorContribuinteComportamento;

    @OneToOne
    public TipoFatorContribuinteComunicacao tipoFatorContribuinteComunicacao;

    @OneToOne
    public TipoFatorContribuinteDesenpenho tipoFatorContribuinteDesenpenho;

    @OneToOne
    public TipoFatorContribuinteOrganizacional tipoFatorContribuinteOrganizacional;

    @OneToOne
    public TipoFatorContribuintePaciente tipoFatorContribuintePaciente;

    @OneToOne
    public TipoFatorContribuinteProfissional tipoFatorContribuinteProfissional;

    @OneToOne
    public TipoFatorContribuinteTrabalho tipoFatorContribuinteTrabalho;

    @OneToOne
    public TipoFatorAtenuanteAgente tipoFatorAtenuanteAgente;

    @OneToOne
    public TipoFatorAtenuanteOrganizacao tipoFatorAtenuanteOrganizacao;

    @OneToOne
    public TipoFatorAtenuantePaciente tipoFatorAtenuantePaciente;

    @OneToOne
    public TipoFatorAtenuanteProfissional tipoFatorAtenuanteProfissional;

    @NotBlank
    public String data;

    @NotBlank
    public String hora;

    @OneToOne
    public Ocorrencia ocorrencia;
}
