package webapp.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.escola_completo.Model.Administrador;
import webapp.escola_completo.Model.VerificaCadastroAdm;



public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm, String>{
    VerificaCadastroAdm findByCpf(String cpf);

    boolean existsById(Class<? extends Administrador> class1);
}
