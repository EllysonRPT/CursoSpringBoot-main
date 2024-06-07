package br.com.du.apirest_senai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.du.apirest_senai.Model.Responsavel;
import br.com.du.apirest_senai.Repository.ReponsavelRepository;

@Controller
public class IndexController {

    @Autowired
    private ReponsavelRepository responsavelRepository;

    @GetMapping("/home")
    public ModelAndView indexRoute() {
        return new ModelAndView("index");
    }

    @PostMapping("/home")
    public ModelAndView acessoResponsavel(@ModelAttribute Responsavel responsavel) {
        ModelAndView mv = new ModelAndView();
        boolean existe = responsavelRepository.existsById(responsavel.getId());
        if (existe) {
            mv.setViewName("redirect:/interna_responsavel");

        } else {
            mv.setViewName("redirect:/home");
        }
        return mv;
    }

    @GetMapping("/interna_responsavel")
    public ModelAndView responsavelRoute() {
        return new ModelAndView("interna_responsavel");
    }
}
