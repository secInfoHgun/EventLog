package com.hgun.sti.models.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tipo_ocorrencia")
public class TipoOcorrencia extends AbstractTipo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}