package com.hgun.sti.models;

import com.hgun.sti.models.types.*;
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

    public String fatorContribuinte;

    @NotNull
    public Boolean pacienteFaleceu;

    @NotNull
    public Boolean pacienteFoiInternado;

    @NotBlank
    public String data;

    @NotBlank
    public String hora;

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

    @OneToOne
    public Analise analise;

    @OneToOne
    public Providencia providencia;

    @OneToOne
    public Obito obito;
}
