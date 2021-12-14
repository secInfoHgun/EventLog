package com.hgun.sti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @GetMapping
    public String homeadministrador(){
        return "dashboard.html";
    }

    @GetMapping("/ocorrencias")
    public String ocorrenciaslistpage(){
        return "ocorrencia/listagemOcorrencia.html";
    }



}
