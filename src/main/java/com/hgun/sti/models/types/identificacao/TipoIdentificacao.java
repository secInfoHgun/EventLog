package com.hgun.sti.models.types.identificacao;

import com.hgun.sti.models.types.AbstractTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tipo_identificacao")
public class TipoIdentificacao extends AbstractTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}
