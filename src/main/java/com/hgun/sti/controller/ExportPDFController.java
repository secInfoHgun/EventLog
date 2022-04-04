package com.hgun.sti.controller;

import com.hgun.sti.components.ExportPDF;
import com.hgun.sti.models.Analise;
import com.hgun.sti.models.Obito;
import com.hgun.sti.models.Providencia;
import com.hgun.sti.repository.*;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/pdf")
public class ExportPDFController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private AnaliseRepository analiseRepository;

    @Autowired
    private ProvidenciaRepository providenciaRepository;

    @Autowired
    private ObitoRepository obitoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/export/{id}")
    public void exportToPDF(@PathVariable Long id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Ocorrência_" + id +".pdf";
        response.setHeader(headerKey, headerValue);

        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var analise = analiseRepository.getAnaliseByIdOcorrencia(id);
        var providencia = providenciaRepository.getProvidenciaByIdOcorrencia(id);
        var obito = obitoRepository.getObitoByIdOcorrencia(id);

        var exporter = new ExportPDF(ocorrencia, analise, providencia, obito);

        exporter.exportOcorrencia(response);
    }

    @GetMapping("/export/comprovante/{id}")
    public void exportComprovanteToPDF(@PathVariable Long id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ComprovanteOcorrência_" + id +".pdf";
        response.setHeader(headerKey, headerValue);

        var ocorrencia = ocorrenciaRepository.findById(id).get();
        Analise analise = null;
        Providencia providencia = null;
        Obito obito = null;

        var exporter = new ExportPDF(ocorrencia, analise, providencia, obito);

        exporter.exportComprovante(response, passwordEncoder);
    }
}
