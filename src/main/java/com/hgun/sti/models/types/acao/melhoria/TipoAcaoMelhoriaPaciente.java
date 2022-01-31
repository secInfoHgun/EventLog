package com.hgun.sti.models.types.acao.melhoria;

import com.hgun.sti.models.types.AbstractTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tipo_acao_melhoria_paciente")
public class TipoAcaoMelhoriaPaciente extends AbstractTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}