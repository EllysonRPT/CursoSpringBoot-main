package br.com.gabriel.lojalivro.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    @GetMapping("/livros-add")
    public ModelAndView getLivrosAdd() {
        ModelAndView mv = new ModelAndView("livros-add");
        return mv;
    }

}
