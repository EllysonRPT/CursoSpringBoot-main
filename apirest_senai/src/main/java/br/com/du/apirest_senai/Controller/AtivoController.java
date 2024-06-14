package br.com.du.apirest_senai.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.du.apirest_senai.Model.AtivoPatrimonial;
import br.com.du.apirest_senai.Repository.AtivoPatrimonialRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AtivoController {
    
    @Autowired
    AtivoPatrimonialRepository repository;

    @GetMapping("/ativos")
    public List<AtivoPatrimonial> getAtivoPatrimonial () {
        return (List<AtivoPatrimonial>) repository.findAll();
    }
    
    @PostMapping("/ativos")
    public ModelAndView postAtivoPatrimonial(@RequestBody AtivoPatrimonial ativoPatrimonial) {
        repository.save(ativoPatrimonial);  
        return new ModelAndView("redirect:/interna_responsavel");   
    }
    
    @GetMapping("/ativos/{id}")
    public Optional<AtivoPatrimonial> getAtivoPatrimonialById(@PathVariable Long id) {
        return repository.findById(id);
    }
    
    @PutMapping("/ativos/{id}")
    public AtivoPatrimonial putAtivoPatrimonial(@PathVariable Long id, @RequestBody AtivoPatrimonial ativoPatrimonial) {
        Optional<AtivoPatrimonial> busca = repository.findById(id);
        if(busca.isPresent()){
            ativoPatrimonial.setId(id);
            return repository.save(ativoPatrimonial);
        } else {
            return null;
        }
    }
    
    @DeleteMapping("/ativos/{id}")
    public void deleteAtivoPatrimonial(@PathVariable Long id){
        repository.deleteById(id);
    }
}
