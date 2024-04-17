package webapp.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.escola_completo.Model.Administrador;
import webapp.escola_completo.Model.Aluno;
import webapp.escola_completo.Repository.AdministradorRepository;
import webapp.escola_completo.Repository.AlunoRepository;
import webapp.escola_completo.Repository.VerificaCadastroAdmRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {
    // atributos
    boolean acessoInternoAdm = false; // Flag para controlar o acesso interno do administrador

    @Autowired
    private AdministradorRepository ar; // Repositório para operações relacionadas ao administrador

    @Autowired
    private VerificaCadastroAdmRepository vcar; // Repositório para verificar o cadastro do administrador

    @Autowired
    private AlunoRepository alunoRepository;

    // métodos

    // Método para cadastrar um aluno no banco de dados
@PostMapping("cadastrar-aluno")
public ModelAndView cadastroAluno(Aluno aluno, RedirectAttributes attributes) {
    // Cria um objeto ModelAndView para redirecionar para a página de login de aluno
    ModelAndView mv = new ModelAndView("redirect:/interna-adm");

    // Tenta salvar o aluno no banco de dados
    try {
        // Aqui você deve ter um repositório adequado para Aluno, similar ao AdministradorRepository
        alunoRepository.save(aluno); // Salva o aluno no banco de dados

        // Adiciona uma mensagem de sucesso aos atributos de redirecionamento
        String mensagem = "Cadastro de aluno realizado com sucesso";
        System.out.println(mensagem);
        attributes.addFlashAttribute("msg", mensagem);
        attributes.addFlashAttribute("classe", "vermelho");
    } catch (Exception e) {
        // Em caso de erro, adiciona uma mensagem de erro aos atributos de redirecionamento
        String mensagem = "Erro ao cadastrar aluno: " + e.getMessage();
        System.out.println(mensagem);
        attributes.addFlashAttribute("msg", mensagem);
        attributes.addFlashAttribute("classe", "vermelho");
    }

    // Retorna o ModelAndView para redirecionar para a página de login de aluno
    return mv;
}


    // Método para cadastrar um administrador no banco de dados
    @PostMapping("cadastrar-adm")
    public ModelAndView cadastroAdmBD(Administrador adm, RedirectAttributes attributes) {
        // Verifica se o CPF do administrador já existe no banco de dados
        boolean verificaCpf = vcar.existsById(adm.getCpf());
    
        // Cria um objeto ModelAndView para redirecionar para a página de login de administrador
        ModelAndView mv = new ModelAndView("redirect:/login-adm");
    
        // Se o CPF não existe, realiza o cadastro do administrador
        if (!verificaCpf) {
            // Salva o administrador no banco de dados
            ar.save(adm);
            
            // Adiciona uma mensagem de sucesso aos atributos de redirecionamento
            String mensagem = "Cadastro Realizado com sucesso";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        } else {
            // Se o CPF já existe no banco de dados, exibe uma mensagem de erro
            String mensagem = "Cadastro Não Realizado: CPF já cadastrado";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }
    
        // Retorna o ModelAndView para redirecionar para a página de login de administrador
        return mv;
    }
    

    // Método para realizar o login do administrador
    @PostMapping("acesso-adm")
    public ModelAndView acessoAdmLogin(@RequestParam String cpf, @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-adm"); // Página interna de acesso

        try {
            // Verifica se o CPF e a senha correspondem a um administrador registrado no banco de dados
            boolean acessoCPF = ar.existsById(cpf); // Verifica se o CPF existe no banco de dados
            boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha()); // Verifica se a senha está correta

            // Se o CPF e a senha estiverem corretos, permite o acesso interno do administrador
            if (acessoCPF && acessoSenha) {
                acessoInternoAdm = true;
            } else {
                String mensagem = "Login Não Efetuado";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
                mv.setViewName("redirect:/login-adm");
            }
            return mv;
        } catch (Exception e) {
            String mensagem = "Login Não Efetuado";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
            mv.setViewName("redirect:/login-adm");
            return mv;
        }
    }

    // Método para acessar a página interna do administrador
    @GetMapping("/interna-adm")
    public ModelAndView acessoPageInternaAdm(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("interna/interna-adm");

        // Verifica se o acesso interno do administrador está permitido
        if (acessoInternoAdm) {
            System.out.println("Acesso Permitido");
        } else {
            String mensagem = "Acesso não Permitido - faça Login";
            System.out.println(mensagem);
            mv.setViewName("redirect:/login-adm");
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }
        return mv;
    }

    // Método para realizar o logout do administrador
    @PostMapping("logout-adm")
    public ModelAndView logoutAdm(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-adm");

        attributes.addFlashAttribute("msg", "Logout Efetuado");
        attributes.addFlashAttribute("classe", "verde");
        acessoInternoAdm = false; // Define o acesso interno do administrador como falso

        return mv;
    }
}