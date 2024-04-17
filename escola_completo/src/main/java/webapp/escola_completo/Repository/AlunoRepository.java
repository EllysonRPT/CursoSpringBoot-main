package webapp.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.escola_completo.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, String> {

    // Aluno fingBySenhaAluno(String senhaAluno);
    // Aluno findByEmailAluno (String emailAluno);
    // Aluno findByNome (String nomeAluno);
    // Aluno findByRaAluno (String raAluno);
    
}
