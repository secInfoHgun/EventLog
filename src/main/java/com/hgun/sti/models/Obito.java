package com.hgun.sti.models;

import com.hgun.sti.models.types.TipoLesao;
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
@Table(name="obitos")
public class Obito {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    public String dataDoObito;

    @NotBlank
    public String numeroDaDeclaracao;

    @NotNull
    @OneToOne
    public TipoLesao tipoLesao;

    @NotBlank
    public String causaDaMorte;

    @NotBlank
    public String data;

    @NotBlank
    public String hora;

    @OneToOne
    public Ocorrencia ocorrencia;
}
