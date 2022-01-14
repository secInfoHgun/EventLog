package com.hgun.sti.controller;

import com.hgun.sti.models.Ocorrencia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador/ocorrencias/providencias")
public class ProvidenciaController {
    @GetMapping("/form")
    public String providenciasformpage(Model model){
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "ocorrencia/formularioProvidencias.html";
    }
}
