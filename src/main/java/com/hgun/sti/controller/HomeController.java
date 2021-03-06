package com.hgun.sti.controller;

import com.hgun.sti.controller.validators.OcorrenciaValidator;
import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.Paciente;
import com.hgun.sti.models.errors.OcorrenciaError;
import com.hgun.sti.repository.OcorrenciaRepository;
import com.hgun.sti.repository.PacienteRepository;
import com.hgun.sti.repository.types.*;
import com.hgun.sti.repository.types.identificacao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

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
    private TipoIdentificacaoRepository tipoIdentificacaoRepository;

    @Autowired
    private TipoIdentificadorRepository tipoIdentificadorRepository;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    private Model setAllLists(Model model){

        model.addAttribute("listaTipoOcorrencia", tipoOcorrenciaRepository.findAll());
        model.addAttribute("listaTipoIncidencia", tipoIncidenciaRepository.findAll());
        model.addAttribute("listaTipoDano", tipoDanoRepository.findAll());
        model.addAttribute("listaTipoFaseAssistencia", tipoFaseAssistenciaRepository.findAll());
        model.addAttribute("listaTipoSetor", tipoSetorRepository.findAll());
        model.addAttribute("listaTipoIdentificacao", tipoIdentificacaoRepository.findAll());
        model.addAttribute("listaTipoIdentificador", tipoIdentificadorRepository.findAll());

        return model;
    }

    @GetMapping
    public String form(Model model){
        if(model.getAttribute("ocorrencia") == null){
            model.addAttribute("ocorrencia", new Ocorrencia());
            model.addAttribute("erros", new OcorrenciaError());
        }

        model = setAllLists(model);

        return "home.html";
    }

    @PostMapping
    public String cadastro(@ModelAttribute Ocorrencia ocorrencia, RedirectAttributes redirectAttributes){
        var erros = OcorrenciaValidator.validarOcorrencia(ocorrencia);

        if(!erros.isEmpty()){
            redirectAttributes.addFlashAttribute("erros", erros);
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        }else{

            var formPaciente = ocorrencia.getPaciente();
            Paciente pacienteBanco;

            if(formPaciente.preccp == null || formPaciente.preccp.isEmpty()){
                pacienteBanco = pacienteRepository.save(formPaciente);
            }else {
                pacienteBanco = pacienteRepository.getPacienteByPreccp(formPaciente.getPreccp());
                if(pacienteBanco == null){
                    pacienteBanco = pacienteRepository.save(formPaciente);
                }
            }

            ocorrencia.setPaciente(pacienteBanco);
            ocorrencia.setVisualizada(false);
            ocorrencia = ocorrenciaRepository.save(ocorrencia);

            redirectAttributes.addFlashAttribute("cadastrou", ocorrencia.getId());
        }

        return "redirect:/";
    }
}
