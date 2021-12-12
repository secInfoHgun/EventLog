package com.hgun.sti.models;

import com.hgun.sti.models.types.TipoRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="pacientes")
public class Paciente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    public String prontuario;

    @NotBlank
    public String nome;

    @NotNull
    public Integer idade;

    @NotBlank
    public Character sexo;
}
