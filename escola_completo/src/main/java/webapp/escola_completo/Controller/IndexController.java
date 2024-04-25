package webapp.escola_completo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    //classe para criação das rotas de navegação

    @GetMapping("/home")
    public ModelAndView acessoHomePage() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @GetMapping("")
    public String acessoHomePage2() {
        return "index";
    }

    @GetMapping("/login-adm")
    public String acessoLoginAdm() {
        return "login/login-adm";
    }

    @GetMapping("/cadastro-adm")
    public String acessoCadastroAdm() {
        return "cadastro/cadastro-adm";
    }
   
    @GetMapping("/cadastrar-professor")
    public String acessoCadastroProfessor() {
        return "interna/cadastrar-professor";
    }
    
    @GetMapping("/login-professor")
    public String acessoLoginprofessor() {
        return "login/login-professor";
    }

    @GetMapping("/login-aluno")
    public String acessoLoginAluno() {
        return "login/login-aluno";
    }
    
    @GetMapping("/cadastrar-aluno")
    public String acessoCadastroAluno() {
        return "interna/cadastrar-aluno";
    } 
    
}
