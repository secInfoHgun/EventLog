package com.hgun.sti.models;

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
@Table(name="providencias")
public class Providencia {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    public String acoesDeMelhoria;

    @NotBlank
    public String acoesParaReduzirRiscos;

    @NotNull
    public Boolean naoCaracterizaEventoAdverso;

    @NotBlank
    public String outrasProvidencias;

    @NotBlank
    public String data;

    @NotBlank
    public String hora;

    @OneToOne
    public Ocorrencia ocorrencia;
}
