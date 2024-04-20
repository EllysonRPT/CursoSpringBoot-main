package webapp.escola_completo.Repository;
import org.springframework.data.repository.CrudRepository;
import webapp.escola_completo.Model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String> {

    // Aluno fingBySenhaAluno(String senhaAluno);
    // Aluno findByEmailAluno (String emailAluno);
    // Aluno findByNome (String nomeAluno);
    // Aluno findByRaAluno (String raAluno);
    
}