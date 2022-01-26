package com.hgun.sti.controller;

import com.hgun.sti.controller.utils.FormatData;
import com.hgun.sti.controller.utils.FormatHora;
import com.hgun.sti.controller.validators.AnaliseValidator;
import com.hgun.sti.models.Analise;
import com.hgun.sti.models.errors.AnaliseError;
import com.hgun.sti.repository.AnaliseRepository;
import com.hgun.sti.repository.OcorrenciaRepository;
import com.hgun.sti.repository.types.TipoConsequenciaOrganizacionalRepository;
import com.hgun.sti.repository.types.fator.atenuante.TipoFatorAtenuanteAgenteRepository;
import com.hgun.sti.repository.types.fator.atenuante.TipoFatorAtenuanteOrganizacaoRepository;
import com.hgun.sti.repository.types.fator.atenuante.TipoFatorAtenuantePacienteRepository;
import com.hgun.sti.repository.types.fator.atenuante.TipoFatorAtenuanteProfissionalRepository;
import com.hgun.sti.repository.types.fator.contribuinte.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/administrador/ocorrencias/analises")
public class AnaliseController {

    @Autowired
    private TipoConsequenciaOrganizacionalRepository tipoConsequenciaOrganizacionalRepository;

    @Autowired
    private TipoFatorContribuinteCognitivoRepository tipoFatorContribuinteCognitivoRepository;

    @Autowired
    private TipoFatorContribuinteComportamentoRepository tipoFatorContribuinteComportamentoRepository;

    @Autowired
    private TipoFatorContribuinteComunicacaoRepository tipoFatorContribuinteComunicacaoRepository;

    @Autowired
    private TipoFatorContribuinteDesenpenhoRepository tipoFatorContribuinteDesenpenhoRepository;

    @Autowired
    private TipoFatorContribuinteOrganizacionalRepository tipoFatorContribuinteOrganizacionalRepository;

    @Autowired
    private TipoFatorContribuintePacienteRepository tipoFatorContribuintePacienteRepository;

    @Autowired
    private TipoFatorContribuinteProfissionalRepository tipoFatorContribuinteProfissionalRepository;

    @Autowired
    private TipoFatorContribuinteTrabalhoRepository tipoFatorContribuinteTrabalhoRepository;

    @Autowired
    private TipoFatorAtenuanteAgenteRepository tipoFatorAtenuanteAgenteRepository;

    @Autowired
    private TipoFatorAtenuanteOrganizacaoRepository tipoFatorAtenuanteOrganizacaoRepository;

    @Autowired
    private TipoFatorAtenuantePacienteRepository tipoFatorAtenuantePacienteRepository;

    @Autowired
    private TipoFatorAtenuanteProfissionalRepository tipoFatorAtenuanteProfissionalRepository;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private AnaliseRepository analiseRepository;

    private Model setAllLists(Model model){

        model.addAttribute("listaTipoConsequenciaOrganizacional", tipoConsequenciaOrganizacionalRepository.findAll());

        model.addAttribute("listaTipoFatorContibuinteCognitivo", tipoFatorContribuinteCognitivoRepository.findAll());
        model.addAttribute("listaTipoFatorContribuinteComportamento", tipoFatorContribuinteComportamentoRepository.findAll());
        model.addAttribute("listaTipoFatorContribuinteComunicacao", tipoFatorContribuinteComunicacaoRepository.findAll());
        model.addAttribute("listaTipoFatorContribuinteDesenpenho", tipoFatorContribuinteDesenpenhoRepository.findAll());
        model.addAttribute("listaTipoFatorContribuinteOrganizacional", tipoFatorContribuinteOrganizacionalRepository.findAll());
        model.addAttribute("listaTipoFatorContribuintePaciente", tipoFatorContribuintePacienteRepository.findAll());
        model.addAttribute("listaTipoFatorContribuinteProfissional", tipoFatorContribuinteProfissionalRepository.findAll());
        model.addAttribute("listaTipoFatorContribuinteTrabalho", tipoFatorContribuinteTrabalhoRepository.findAll());

        model.addAttribute("listaTipoFatorAtenuanteAgente", tipoFatorAtenuanteAgenteRepository.findAll());
        model.addAttribute("listaTipoFatorAtenuanteOrganizacao", tipoFatorAtenuanteOrganizacaoRepository.findAll());
        model.addAttribute("listaTipoFatorAtenuantePaciente", tipoFatorAtenuantePacienteRepository.findAll());
        model.addAttribute("listaTipoFatorAtenuanteProfissional", tipoFatorAtenuanteProfissionalRepository.findAll());

        return model;
    }

    @GetMapping("/form")
    public String analisesformpage(Model model){
        if(model.getAttribute("analise") == null){
            model.addAttribute("analise", getAnaliseComData(new Analise()));
            model.addAttribute("erros", new AnaliseError());
            model.addAttribute("info", false);
        }

        model = setAllLists(model);

        return "ocorrencia/formularioAnalise.html";
    }

    @PostMapping("/form/{id}")
    public String analisesformregister(@PathVariable Long id, @ModelAttribute Analise analise, RedirectAttributes redirectAttributes){
        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var erros = AnaliseValidator.validarAnalise(analise);

        if(!erros.isEmpty()){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            redirectAttributes.addFlashAttribute("analise", getAnaliseComData(analise));
            redirectAttributes.addFlashAttribute("erros", erros);
            redirectAttributes.addFlashAttribute("info", false);
            return "redirect:/administrador/ocorrencias/analises/form";
        }

        analise.setOcorrencia(ocorrencia);
        analiseRepository.save(getAnaliseComData(analise));

        return "redirect:/administrador/ocorrencias/analises/info/"+id;
    }

    @GetMapping("/info/{id}")
    public String analisesInfo(@PathVariable Long id, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var analise = analiseRepository.getAnaliseByIdOcorrencia(id);

        if(analise == null){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            return "redirect:/administrador/ocorrencias/analises/form";
        }

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("analise", analise);
        redirectAttributes.addFlashAttribute("erros", new AnaliseError());
        redirectAttributes.addFlashAttribute("info", true);

        return "redirect:/administrador/ocorrencias/analises/form";
    }

    private Analise getAnaliseComData(Analise analise){
        var dataAtual = LocalDateTime.now();

        analise.setData(FormatData.formatarData(dataAtual));
        analise.setHora(FormatHora.formatarHora(dataAtual));

        return analise;
    }

    @GetMapping("/edit/{id}")
    public String analisesEdit(@PathVariable Long id, RedirectAttributes redirectAttributes){
        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var analise = analiseRepository.getAnaliseByIdOcorrencia(id);

        if(analise == null){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            return "redirect:/administrador/ocorrencias/analises/form";
        }

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("analise", getAnaliseComData(analise));
        redirectAttributes.addFlashAttribute("erros", new AnaliseError());
        redirectAttributes.addFlashAttribute("info", false);

        return "redirect:/administrador/ocorrencias/analises/form";
    }

}
