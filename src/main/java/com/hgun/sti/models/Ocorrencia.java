package com.hgun.sti.models;

import com.hgun.sti.models.types.TipoDano;
import com.hgun.sti.models.types.TipoIncidencia;
import com.hgun.sti.models.types.TipoOcorrencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="ocorrencias")
public class Ocorrencia {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    public Paciente paciente;

    @NotBlank
    public String titulo;

    @NotBlank
    public String descricao;

    public String fatorContribuinte;

    @NotNull
    public Boolean pacienteFaleceu;

    @NotNull
    public Boolean pacienteFoiInternado;

    @NotNull
    public Date data;

    @NonNull
    @OneToOne
    TipoOcorrencia tipoOcorrencia;

    @NonNull
    @OneToOne
    TipoIncidencia tipoIncidencia;

    @NonNull
    @OneToOne
    TipoDano tipoDano;
}
