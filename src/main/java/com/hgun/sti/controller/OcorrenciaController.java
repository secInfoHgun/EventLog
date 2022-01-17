package com.hgun.sti.controller;

import com.hgun.sti.controller.validators.OcorrenciaValidator;
import com.hgun.sti.models.Ocorrencia;
import com.hgun.sti.models.Paciente;
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
@RequestMapping("/administrador/ocorrencias")
public class OcorrenciaController {

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
    public String ocorrenciaslistpage(Model model){

        if(model.getAttribute("ocorrencias") == null){
            model.addAttribute("ocorrenciaFiltro", new Ocorrencia());
            model.addAttribute("ocorrencias", ocorrenciaRepository.getAll());
        }

        model.addAttribute("listaTipoOcorrencia", tipoOcorrenciaRepository.findAll());
        model.addAttribute("listaTipoIncidencia", tipoIncidenciaRepository.findAll());
        model.addAttribute("listaTipoDano", tipoDanoRepository.findAll());
        model.addAttribute("listaTipoFaseAssistencia", tipoFaseAssistenciaRepository.findAll());
        model.addAttribute("listaTipoSetor", tipoSetorRepository.findAll());

        return "ocorrencia/listagemOcorrencia.html";
    }

    @GetMapping("/form")
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

    @PostMapping("/form")
    public String ocorrenciasformregister(@ModelAttribute Ocorrencia ocorrencia, RedirectAttributes redirectAttributes){
        var erros = OcorrenciaValidator.validarOcorrencia(ocorrencia);

        if(!erros.isEmpty()){
            redirectAttributes.addFlashAttribute("erros", erros);
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            redirectAttributes.addFlashAttribute("info", false);
            return "redirect:/administrador/ocorrencias/form";
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
            ocorrenciaRepository.save(ocorrencia);

            redirectAttributes.addFlashAttribute("cadastrou", true);
        }

        return "redirect:/administrador/ocorrencias";
    }

    @GetMapping("/info/{id}")
    public String ocorrenciasformpage(@PathVariable Long id, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.findById(id).get();

        ocorrencia.setVisualizada(true);

        ocorrenciaRepository.save(ocorrencia);

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("erros", new OcorrenciaError());
        redirectAttributes.addFlashAttribute("info", true);

        return "redirect:/administrador/ocorrencias/form";
    }

    @PostMapping("/listfilter")
    public String ocorrenciaslistfilter(@ModelAttribute Ocorrencia ocorrenciaFilter, RedirectAttributes redirectAttributes){
        var ocorrencias = ocorrenciaRepository.getAll();

        if(!ocorrencias.isEmpty()){
            if(ocorrenciaFilter.paciente.preccp != null && !ocorrenciaFilter.paciente.preccp.isEmpty() && !ocorrenciaFilter.paciente.preccp.equals("")){
                ocorrencias.removeIf(o -> !o.paciente.preccp.equals(ocorrenciaFilter.paciente.preccp));
            }

            if(ocorrenciaFilter.tipoSetor != null && ocorrenciaFilter.tipoSetor.id != null){
                ocorrencias.removeIf(o -> o.tipoSetor.id != ocorrenciaFilter.tipoSetor.id);
            }

            if(ocorrenciaFilter.data != null && !ocorrenciaFilter.data.isEmpty() && !ocorrenciaFilter.data.equals("")){
                ocorrencias.removeIf(o -> !o.data.equals(ocorrenciaFilter.data));
            }

            if(ocorrenciaFilter.hora != null && !ocorrenciaFilter.hora.isEmpty() && !ocorrenciaFilter.hora.equals("")){
                ocorrencias.removeIf(o -> !o.hora.equals(ocorrenciaFilter.hora));
            }

            if(ocorrenciaFilter.tipoOcorrencia != null && ocorrenciaFilter.tipoOcorrencia.id != null){
                ocorrencias.removeIf(o -> o.tipoOcorrencia.id != ocorrenciaFilter.tipoOcorrencia.id);
            }

            if(ocorrenciaFilter.tipoFaseAssistencia != null && ocorrenciaFilter.tipoFaseAssistencia.id != null){
                ocorrencias.removeIf(o -> o.tipoFaseAssistencia.id != ocorrenciaFilter.tipoFaseAssistencia.id);
            }

            if(ocorrenciaFilter.tipoIncidencia != null && ocorrenciaFilter.tipoIncidencia.id != null){
                ocorrencias.removeIf(o -> o.tipoIncidencia.id != ocorrenciaFilter.tipoIncidencia.id);
            }

            if(ocorrenciaFilter.tipoDano != null && ocorrenciaFilter.tipoDano.id != null){
                ocorrencias.removeIf(o -> o.tipoDano.id != ocorrenciaFilter.tipoDano.id);
            }

            if(ocorrenciaFilter.pacienteFoiInternado != null && ocorrenciaFilter.pacienteFoiInternado != false){
                ocorrencias.removeIf(o -> o.pacienteFoiInternado != ocorrenciaFilter.pacienteFoiInternado);
            }

            if(ocorrenciaFilter.pacienteFaleceu != null && ocorrenciaFilter.pacienteFaleceu != false){
                ocorrencias.removeIf(o -> o.pacienteFaleceu != ocorrenciaFilter.pacienteFaleceu);
            }

            if(ocorrenciaFilter.visualizada != null && ocorrenciaFilter.visualizada != false){
                ocorrencias.removeIf(o -> o.visualizada != ocorrenciaFilter.visualizada);
            }
        }

        redirectAttributes.addFlashAttribute("ocorrenciaFiltro", ocorrenciaFilter);
        redirectAttributes.addFlashAttribute("ocorrencias", ocorrencias);

        return "redirect:/administrador/ocorrencias";
    }
}
