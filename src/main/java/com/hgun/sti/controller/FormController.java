package com.hgun.sti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FormController {

    @GetMapping
    public String form(){
        return "ocorrencia/formularioOcorrencia.html";
    }
}
