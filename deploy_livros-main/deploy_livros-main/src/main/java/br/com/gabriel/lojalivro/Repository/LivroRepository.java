package br.com.gabriel.lojalivro.Repository;
import org.springframework.data.repository.CrudRepository;
import br.com.gabriel.lojalivro.Model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer>{
    
}
