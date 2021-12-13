package com.hgun.sti.models;

import com.hgun.sti.models.types.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    Paciente paciente;

    @NotBlank
    String resumo;

    @NotBlank
    String descricao;

    String fatorContribuinte;

    @NotNull
    Boolean pacienteFaleceu;

    @NotNull
    Boolean pacienteFoiInternado;

    @NotNull
    Date data;

    @NonNull
    @OneToOne
    TipoOcorrencia tipoOcorrencia;

    @NonNull
    @OneToOne
    TipoIncidencia tipoIncidencia;

    @NonNull
    @OneToOne
    TipoDano tipoDano;

    @NonNull
    @OneToOne
    TipoSetor tipoSetor;

    @NonNull
    @OneToOne
    TipoFaseAssistencia tipoFaseAssistencia;
}
