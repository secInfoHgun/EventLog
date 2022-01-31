package com.hgun.sti.models;

import com.hgun.sti.models.types.acao.melhoria.TipoAcaoMelhoriaOrganizacao;
import com.hgun.sti.models.types.acao.melhoria.TipoAcaoMelhoriaPaciente;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoOrganizacional;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoPaciente;
import com.hgun.sti.models.types.acao.reduzirRisco.TipoAcaoReduzirRiscoProfissional;
import com.hgun.sti.models.types.fator.atenuante.TipoFatorAtenuanteProfissional;
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

    @OneToOne
    public TipoAcaoMelhoriaPaciente tipoAcaoMelhoriaPaciente;

    @OneToOne
    public TipoAcaoMelhoriaOrganizacao tipoAcaoMelhoriaOrganizacao;

    @OneToOne
    public TipoAcaoReduzirRiscoPaciente tipoAcaoReduzirRiscoPaciente;

    @OneToOne
    public TipoAcaoReduzirRiscoProfissional tipoAcaoReduzirRiscoProfissional;

    @OneToOne
    public TipoAcaoReduzirRiscoOrganizacional tipoAcaoReduzirRiscoOrganizacional;

    @NotNull
    public Boolean naoAdotadasAcoesReducaoRisco;

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
