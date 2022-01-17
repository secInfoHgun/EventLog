package com.hgun.sti.controller;

import com.hgun.sti.controller.utils.FormatData;
import com.hgun.sti.controller.utils.FormatHora;
import com.hgun.sti.controller.validators.ObitoValidator;
import com.hgun.sti.models.Obito;
import com.hgun.sti.models.errors.ObitoError;
import com.hgun.sti.repository.ObitoRepository;
import com.hgun.sti.repository.OcorrenciaRepository;
import com.hgun.sti.repository.types.TipoLesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/administrador/ocorrencias/obitos")
public class ObitoController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private ObitoRepository obitoRepository;

    @Autowired
    private TipoLesaoRepository tipoLesaoRepository;

    @GetMapping("/form")
    public String obitosformpage(Model model){
        if(model.getAttribute("obito") == null){
            model.addAttribute("obito", getObitoComData(new Obito()));
            model.addAttribute("erros", new ObitoError());
            model.addAttribute("info", false);
        }

        model.addAttribute("listaTipoLesao", tipoLesaoRepository.findAll());

        return "ocorrencia/formularioObito.html";
    }

    @PostMapping("/form/{id}")
    public String analisesformregister(@PathVariable Long id, @ModelAttribute Obito obito, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var erros = ObitoValidator.validarObito(obito);

        if(!erros.isEmpty()){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            redirectAttributes.addFlashAttribute("obito", getObitoComData(obito));
            redirectAttributes.addFlashAttribute("erros", erros);
            redirectAttributes.addFlashAttribute("info", false);
            return "redirect:/administrador/ocorrencias/obitos/form";
        }

        obito.setOcorrencia(ocorrencia);
        var obitoBanco = obitoRepository.save(getObitoComData(obito));

        return "redirect:/administrador/ocorrencias/obitos/info/"+id;
    }

    @GetMapping("/info/{id}")
    public String ocorrenciasformpage(@PathVariable Long id, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var obito = obitoRepository.getObitoByIdOcorrencia(id);

        if(obito == null){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            return "redirect:/administrador/ocorrencias/obitos/form";
        }

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("obito", obito);
        redirectAttributes.addFlashAttribute("erros", new ObitoError());
        redirectAttributes.addFlashAttribute("info", true);

        return "redirect:/administrador/ocorrencias/obitos/form";
    }

    private Obito getObitoComData(Obito obito){
        var dataAtual = LocalDateTime.now();

        obito.setData(FormatData.formatarData(dataAtual));
        obito.setHora(FormatHora.formatarHora(dataAtual));

        return obito;
    }

    @GetMapping("/edit/{id}")
    public String analisesEdit(@PathVariable Long id, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.findById(id).get();
        var obito = obitoRepository.getObitoByIdOcorrencia(id);

        if(obito == null){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            return "redirect:/administrador/ocorrencias/obitos/form";
        }

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("obito", getObitoComData(obito));
        redirectAttributes.addFlashAttribute("erros", new ObitoError());
        redirectAttributes.addFlashAttribute("info", false);

        return "redirect:/administrador/ocorrencias/obitos/form";
    }
}
