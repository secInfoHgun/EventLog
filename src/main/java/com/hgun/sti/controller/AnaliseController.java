package com.hgun.sti.controller;

import com.hgun.sti.models.Ocorrencia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador/ocorrencias/analises")
public class AnaliseController {
    @GetMapping("/form")
    public String analisesformpage(Model model){
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "ocorrencia/formularioAnalise.html";
    }

}
