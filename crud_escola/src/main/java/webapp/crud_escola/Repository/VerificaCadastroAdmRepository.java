package webapp.crud_escola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.crud_escola.Model.VerificaCadastroAdm;

public interface VerificaCadastroAdmRepository extends CrudRepository <VerificaCadastroAdm, String> {

    VerificaCadastroAdm findByndCpf (String cpf);

    VerificaCadastroAdm findByndNome (String nome);

    

}
