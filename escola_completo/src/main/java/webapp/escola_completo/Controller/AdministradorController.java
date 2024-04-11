package webapp.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.escola_completo.Model.Administrador;
import webapp.escola_completo.Repository.AdministradorRepository;
import webapp.escola_completo.Repository.VerificaCadastroAdmRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {
    // atributos
    boolean acessoInternoAdm = false; // Variável para controlar o acesso interno do administrador

    @Autowired
    private AdministradorRepository ar; // Repositório para lidar com operações relacionadas aos administradores

    @Autowired
    private VerificaCadastroAdmRepository vcar; // Repositório para verificar o cadastro do administrador

    // métodos

    // Método para cadastrar um novo administrador no banco de dados
    @PostMapping("cadastrar-adm")
    public ModelAndView cadastroAdmBD(Administrador adm) {

        // Verifica se o CPF já está cadastrado no banco de dados
        boolean verificaCpf = vcar.existsById(adm.getCpf());

        ModelAndView mv = new ModelAndView("login/login-adm");

        if (verificaCpf) { // Se o CPF já está cadastrado
            ar.save(adm); // Salva o novo administrador no banco de dados
            String mensagem = "Cadastro Realizado com sucesso";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "verde");
        } else { // Se o CPF não está cadastrado
            String mensagem = "Cadastro Não Realizado";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
        }

        return mv;
    }

    // Método para verificar o acesso do administrador ao sistema
    @PostMapping("acesso-adm")
    public ModelAndView acessoAdmLogin(@RequestParam String cpf,
            @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-adm"); // Redireciona para a página interna de acesso

        try {
            // Verifica se o CPF e a senha fornecidos correspondem aos dados no banco de dados
            boolean acessoCPF = ar.existsById(cpf); // Verifica se o CPF existe no banco de dados
            boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha()); // Verifica se a senha é correta

            if (acessoCPF && acessoSenha) { // Se o CPF e a senha estiverem corretos
                String mensagem = "Login Realizado com sucesso";
                System.out.println(mensagem);
                acessoInternoAdm = true; // Define o acesso interno do administrador como verdadeiro
                mv.addObject("msg", mensagem);
                mv.addObject("classe", "verde");
            } else { // Se o CPF ou a senha estiverem incorretos
                String mensagem = "Login Não Efetuado";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
                mv.setViewName("redirect:/login-adm");
            }
            
        } catch (Exception e) {
            String mensagem = "Login Não Efetuado";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
            mv.setViewName("redirect:/login-adm");
        }
        return mv;
    }

    // Método para acessar a página interna do administrador
    @GetMapping("/interna-adm")
    public ModelAndView acessoPageInternaAdm(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("interna/interna-adm");
        if (acessoInternoAdm) { // Se o acesso interno do administrador for verdadeiro
            System.out.println("Acesso Permitido");
        } else { // Se o acesso interno do administrador for falso
            String mensagem = "Acesso não Permitido - faça Login";
            System.out.println(mensagem);
            mv.setViewName("redirect:/login-adm");
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }

        return mv;
    }

    @PostMapping("logout-adm")
    public ModelAndView logoutAdm() {
        acessoInternoAdm = false; // Define o acesso interno do administrador como falso ao fazer logout
        ModelAndView mv = new ModelAndView("redirect:/login-adm"); // Redireciona para a página de login do administrador
        return mv;
    }
    
}
