package com.hgun.sti.models;

import com.hgun.sti.models.types.*;
import com.hgun.sti.models.types.identificacao.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name="ocorrencias")
public class Ocorrencia {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    public Paciente paciente;

    @NotBlank
    public String resumo;

    @NotBlank
    public String descricao;

    @NotBlank
    public String diagnostico;

    public String fatorContribuinte;

    @NotNull
    public Boolean pacienteFaleceu;

    @NotNull
    public Boolean pacienteFoiInternado;

    @NotBlank
    public String dataDaOcorrencia;

    @NotBlank
    public String horaDaOcorrencia;

    @NotBlank
    public String dataDaInternacao;

    @NotBlank
    public String horaDaInternacao;

    @NotNull
    public Boolean visualizada;



    @NotNull
    @OneToOne
    public TipoOcorrencia tipoOcorrencia;

    @NotNull
    @OneToOne
    public TipoIncidencia tipoIncidencia;

    @NotNull
    @OneToOne
    public TipoDano tipoDano;

    @NotNull
    @OneToOne
    public TipoSetor tipoSetor;

    @NotNull
    @OneToOne
    public TipoFaseAssistencia tipoFaseAssistencia;

    @NotNull
    @OneToOne
    public TipoIdentificacao tipoIdentificacao;

    @NotNull
    @OneToOne
    public TipoIdentificador tipoIdentificador;
}
