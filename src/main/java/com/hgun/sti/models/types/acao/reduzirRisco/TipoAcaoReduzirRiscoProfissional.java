package com.hgun.sti.models.types.acao.reduzirRisco;

import com.hgun.sti.models.types.AbstractTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tipo_acao_reduzir_risco_profissional")
public class TipoAcaoReduzirRiscoProfissional extends AbstractTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}