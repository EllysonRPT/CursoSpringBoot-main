package webapp.escola_completo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aluno implements Serializable {
    
    @Id
    private String nomeAluno;
    private String emailAluno;
    private String raAluno;
    private String senhaAluno;

    public String getNomeAluno() {
        return nomeAluno;
    }
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    public String getEmailAluno() {
        return emailAluno;
    }
    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }
    public String getRaAluno() {
        return raAluno;
    }
    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }
    public String getSenhaAluno() {
        return senhaAluno;
    }
    public void setSenhaAluno(String senhaAluno) {
        this.senhaAluno = senhaAluno;
    }

}
