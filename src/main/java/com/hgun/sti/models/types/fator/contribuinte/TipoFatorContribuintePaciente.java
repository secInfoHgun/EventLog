package com.hgun.sti.models.types.fator.contribuinte;

import com.hgun.sti.models.types.AbstractTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tipo_fator_contribuinte_paciente")
public class TipoFatorContribuintePaciente extends AbstractTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}
