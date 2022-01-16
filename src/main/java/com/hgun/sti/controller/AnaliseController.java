package com.hgun.sti.controller;

import com.hgun.sti.controller.utils.FormatData;
import com.hgun.sti.controller.utils.FormatHora;
import com.hgun.sti.controller.validators.AnaliseValidator;
import com.hgun.sti.models.Analise;
import com.hgun.sti.models.errors.AnaliseError;
import com.hgun.sti.repository.AnaliseRepository;
import com.hgun.sti.repository.OcorrenciaRepository;
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
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private AnaliseRepository analiseRepository;


    @GetMapping("/form")
    public String analisesformpage(Model model){
        if(model.getAttribute("analise") == null){
            model.addAttribute("analise", getAnaliseComData(new Analise()));
            model.addAttribute("erros", new AnaliseError());
            model.addAttribute("info", false);
        }

        return "ocorrencia/formularioAnalise.html";
    }

    @PostMapping("/form/{id}")
    public String analisesformregister(@PathVariable Long id, @ModelAttribute Analise analise, RedirectAttributes redirectAttributes){
        var ocorrencia = ocorrenciaRepository.getById(id);
        var erros = AnaliseValidator.validarAnalise(analise);

        System.out.println(ocorrencia);

        if(!erros.isEmpty()){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            redirectAttributes.addFlashAttribute("analise", getAnaliseComData(analise));
            redirectAttributes.addFlashAttribute("erros", erros);
            redirectAttributes.addFlashAttribute("info", false);
            return "redirect:/administrador/ocorrencias/analises/form";
        }

        analise.setOcorrencia(ocorrencia);
        var analiseBanco = analiseRepository.save(getAnaliseComData(analise));

        return "redirect:/administrador/ocorrencias/analises/info/"+id;
    }

    @GetMapping("/info/{id}")
    public String analisesInfo(@PathVariable Long id, RedirectAttributes redirectAttributes){

        var ocorrencia = ocorrenciaRepository.getById(id);
        var analise = analiseRepository.getAnaliseByIdOcorrencia(id);

        System.out.println(ocorrencia);
        System.out.println(analise);

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
        var ocorrencia = ocorrenciaRepository.getById(id);
        var analise = analiseRepository.getAnaliseByIdOcorrencia(id);

        System.out.println(ocorrencia);
        System.out.println(analise);

        if(analise == null){
            redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
            return "redirect:/administrador/ocorrencias/analises/form";
        }

        redirectAttributes.addFlashAttribute("ocorrencia", ocorrencia);
        redirectAttributes.addFlashAttribute("analise", analise);
        redirectAttributes.addFlashAttribute("erros", new AnaliseError());
        redirectAttributes.addFlashAttribute("info", false);

        return "redirect:/administrador/ocorrencias/analises/form";
    }

}
