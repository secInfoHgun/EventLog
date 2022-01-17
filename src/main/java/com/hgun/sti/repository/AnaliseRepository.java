package com.hgun.sti.repository;

import com.hgun.sti.models.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnaliseRepository extends JpaRepository<Analise, Long> {
    @Query("SELECT a FROM Analise a WHERE a.ocorrencia.id = :id")
    public Analise getAnaliseByIdOcorrencia(@Param("id") Long id);
}
