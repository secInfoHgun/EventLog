package com.hgun.sti.controller;

import com.hgun.sti.controller.validators.OcorrenciaValidator;
import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.errors.OcorrenciaError;
import com.hgun.sti.repository.OcorrenciaRepository;
import com.hgun.sti.repository.PacienteRepository;
import com.hgun.sti.repository.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

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
    public String homeadministrador(){
        return "dashboard.html";
    }

    @GetMapping("/ocorrencias")
    public String ocorrenciaslistpage(Model model){

        model.addAttribute("ocorrenciaFiltro", new Ocorrencia());
        model.addAttribute("ocorrencias", ocorrenciaRepository.getAll());
        model.addAttribute("listaTipoOcorrencia", tipoOcorrenciaRepository.findAll());
        model.addAttribute("listaTipoIncidencia", tipoIncidenciaRepository.findAll());
        model.addAttribute("listaTipoDano", tipoDanoRepository.findAll());
        model.addAttribute("listaTipoFaseAssistencia", tipoFaseAssistenciaRepository.findAll());
        model.addAttribute("listaTipoSetor", tipoSetorRepository.findAll());

        return "ocorrencia/listagemOcorrencia.html";
    }

    @GetMapping("/ocorrencias/form")
    public String ocorrenciasformpage(Model model){
        if(model.getAttribute("ocorrencia") == null){
            model.addAttribute("ocorrencia", new Ocorrencia());
            model.addAttribute("erros", new OcorrenciaError());
            model.addAttribute("info", false);
        }

        model.addAttribute("listaTipoOcorrencia", tipoOcorrenciaRepository.findAll());
        model.addAttribute("listaTipoIncidencia", tipoIncidenciaRepository.findAll());
        model.addAttribute("listaTipoDano", tipoDanoRepository.findAll());
        model.addAttribute("listaTipoFaseAssistencia", tipoFaseAssistenciaRepository.findAll());
        model.addAttribute("listaTipoSetor", tipoSetorRepository.findAll());

        return "ocorrencia/formularioOcorrencia.html";
    }

    @PostMapping("/ocorrencias/form")
    public String ocorrenciasformregister(@ModelAttribute Ocorrencia ocorrencia, RedirectAttributes redirectAttributes){
        var erros = OcorrenciaValidator.validarOcorrencia(ocorrencia);

        if(!erros.isEmpty()){
            redirectAttributes.addFlashAttribute("erros", erros);
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            redirectAttributes.addFlashAttribute("info", false);
        }else{

            var formPaciente = ocorrencia.getPaciente();

            var pacienteBanco = pacienteRepository.getPacienteByProntuario(formPaciente.getProntuario());

            if(pacienteBanco == null){
                pacienteBanco = pacienteRepository.save(formPaciente);
            }

            ocorrencia.setPaciente(pacienteBanco);
            ocorrencia.setVisualizada(false);
            ocorrenciaRepository.save(ocorrencia);

        }

        return "redirect:/administrador/ocorrencias";
    }

    @GetMapping("/ocorrencias/info/{id}")
    public String ocorrenciasformpage(@PathVariable Long id, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.getById(id);

        System.out.println(ocorrencia);

        ocorrencia.setVisualizada(true);

        ocorrenciaRepository.save(ocorrencia);

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("erros", new OcorrenciaError());
        redirectAttributes.addFlashAttribute("info", true);

        return "redirect:/administrador/ocorrencias/form";
    }
}
