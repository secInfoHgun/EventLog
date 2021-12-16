package com.hgun.sti.repository;

import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    @Query("SELECT o FROM Ocorrencia o ORDER BY o.id DESC")
    List<Ocorrencia> getAll();
}
