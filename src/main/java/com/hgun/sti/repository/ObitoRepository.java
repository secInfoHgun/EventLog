package com.hgun.sti.repository;

import com.hgun.sti.models.Obito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ObitoRepository extends JpaRepository<Obito, Long> {
    @Query("SELECT o FROM Obito o WHERE o.ocorrencia.id = :id")
    public Obito getObitoByIdOcorrencia(@Param("id") Long id);
}
