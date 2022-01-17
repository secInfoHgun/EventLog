package com.hgun.sti.repository;

import com.hgun.sti.models.Providencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvidenciaRepository extends JpaRepository<Providencia, Long> {
    @Query("SELECT p FROM Providencia p WHERE p.ocorrencia.id = :id")
    Providencia getProvidenciaByIdOcorrencia(@Param("id") Long id);
}
