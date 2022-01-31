package com.hgun.sti.controller;

import com.hgun.sti.controller.utils.FormatData;
import com.hgun.sti.controller.utils.FormatHora;
import com.hgun.sti.controller.validators.ProvidenciaValidator;
import com.hgun.sti.models.Providencia;
import com.hgun.sti.models.errors.ProvidenciaError;
import com.hgun.sti.repository.OcorrenciaRepository;
import com.hgun.sti.repository.ProvidenciaRepository;
import com.hgun.sti.repository.types.acao.melhoria.TipoAcaoMelhoriaOrganizacaoRepository;
import com.hgun.sti.repository.types.acao.melhoria.TipoAcaoMelhoriaPacienteRepository;
import com.hgun.sti.repository.types.acao.reduzirRisco.TipoAcaoReduzirRiscoOrganizacionalRepository;
import com.hgun.sti.repository.types.acao.reduzirRisco.TipoAcaoReduzirRiscoPacienteRepository;
import com.hgun.sti.repository.types.acao.reduzirRisco.TipoAcaoReduzirRiscoProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/administrador/ocorrencias/providencias")
public class ProvidenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private ProvidenciaRepository providenciaRepository;

    @Autowired
    private TipoAcaoMelhoriaPacienteRepository tipoAcaoMelhoriaPacienteRepository;

    @Autowired
    private TipoAcaoMelhoriaOrganizacaoRepository tipoAcaoMelhoriaOrganizacaoRepository;

    @Autowired
    private TipoAcaoReduzirRiscoProfissionalRepository tipoAcaoReduzirRiscoProfissionalRepository;

    @Autowired
    private TipoAcaoReduzirRiscoPacienteRepository tipoAcaoReduzirRiscoPacienteRepository;

    @Autowired
    private TipoAcaoReduzirRiscoOrganizacionalRepository tipoAcaoReduzirRiscoOrganizacionalRepository;

    @GetMapping("/form")
    public String providenciasformpage(Model model){
        if(model.getAttribute("providencia") == null){
            model.addAttribute("providencia", getProvidenciaComData(new Providencia()));
            model.addAttribute("erros", new ProvidenciaError());
            model.addAttribute("info", false);
        }

        model.addAttribute("listaTipoAcaoMelhoriaOrganizacao", tipoAcaoMelhoriaOrganizacaoRepository.findAll());
        model.addAttribute("listaTipoAcaoMelhoriaPaciente", tipoAcaoMelhoriaPacienteRepository.findAll());
        model.addAttribute("listaTipoAcaoReduzirRiscoOrganizacional", tipoAcaoReduzirRiscoOrganizacionalRepository.findAll());
        model.addAttribute("listaTipoAcaoReduzirRiscoPaciente", tipoAcaoReduzirRiscoPacienteRepository.findAll());
        model.addAttribute("listaTipoAcaoReduzirRiscoProfissional", tipoAcaoReduzirRiscoProfissionalRepository.findAll());

        return "ocorrencia/formularioProvidencias.html";
    }

    @PostMapping("/form/{id}")
    public String analisesformregister(@PathVariable Long id, @ModelAttribute Providencia providencia, RedirectAttributes redirectAttributes){
        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var erros = ProvidenciaValidator.validarProvidencia(providencia);

        if(!erros.isEmpty()){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            redirectAttributes.addFlashAttribute("providencia", getProvidenciaComData(providencia));
            redirectAttributes.addFlashAttribute("erros", erros);
            redirectAttributes.addFlashAttribute("info", false);
            return "redirect:/administrador/ocorrencias/providencias/form";
        }

        providencia.setOcorrencia(ocorrencia);
        providenciaRepository.save(getProvidenciaComData(providencia));

        return "redirect:/administrador/ocorrencias/providencias/info/"+id;
    }

    @GetMapping("/info/{id}")
    public String ocorrenciasformpage(@PathVariable Long id, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var providencia = providenciaRepository.getProvidenciaByIdOcorrencia(id);

        if(providencia == null){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            return "redirect:/administrador/ocorrencias/providencias/form";
        }

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("providencia", providencia);
        redirectAttributes.addFlashAttribute("erros", new ProvidenciaError());
        redirectAttributes.addFlashAttribute("info", true);

        return "redirect:/administrador/ocorrencias/providencias/form";
    }

    private Providencia getProvidenciaComData(Providencia providencia){
        var dataAtual = LocalDateTime.now();

        providencia.setData(FormatData.formatarData(dataAtual));
        providencia.setHora(FormatHora.formatarHora(dataAtual));

        return providencia;
    }

    @GetMapping("/edit/{id}")
    public String analisesEdit(@PathVariable Long id, RedirectAttributes redirectAttributes){
        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var providencia = providenciaRepository.getProvidenciaByIdOcorrencia(id);

        if(providencia == null){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            return "redirect:/administrador/ocorrencias/providencias/form";
        }

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("providencia", getProvidenciaComData(providencia));
        redirectAttributes.addFlashAttribute("erros", new ProvidenciaError());
        redirectAttributes.addFlashAttribute("info", false);

        return "redirect:/administrador/ocorrencias/providencias/form";
    }
}
