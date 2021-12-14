package com.hgun.sti.controller;

import com.hgun.sti.controller.validators.OcorrenciaValidator;
import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.repository.OcorrenciaRepository;
import com.hgun.sti.repository.PacienteRepository;
import com.hgun.sti.repository.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class FormController {

    @Autowired
    private TipoOcorrenciaRepository tipoOcorrenciaRepository;

    @Autowired
    private TipoIncidenciaRepository tipoIncidenciaRepository;

    @Autowired
    private TipoDanoRepository tipoDanoRepository;

    @Autowired
    private TipoFaseAssistenciaRepository tipoFaseAssistenciaRepository;

    @Autowired
    private TipoSetorRepository tipoSetorRepository;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public String form(Model model){
        model.addAttribute("ocorrencia", new Ocorrencia());
        model.addAttribute("listaTipoOcorrencia", tipoOcorrenciaRepository.findAll());
        model.addAttribute("listaTipoIncidencia", tipoIncidenciaRepository.findAll());
        model.addAttribute("listaTipoDano", tipoDanoRepository.findAll());
        model.addAttribute("listaTipoFaseAssistencia", tipoFaseAssistenciaRepository.findAll());
        model.addAttribute("listaTipoSetor", tipoSetorRepository.findAll());
        model.addAttribute("erroNome", null);

        return "ocorrencia/formularioOcorrencia.html";
    }

    @PostMapping
    public String cadastro(@ModelAttribute Ocorrencia ocorrencia, BindingResult erros, Model model){
        erros = OcorrenciaValidator.validarOcorrencia(ocorrencia,erros);

        if(erros.hasErrors()){

            var err = erros.getAllErrors();
            System.out.println(err.get(0).getObjectName() + " - " + err.get(0).getDefaultMessage());
//            if(){}
//            model.addAttribute("erroNome", null);
            return "ocorrencia/formularioOcorrencia.html";
        }

        return "redirect:/";
    }
}
