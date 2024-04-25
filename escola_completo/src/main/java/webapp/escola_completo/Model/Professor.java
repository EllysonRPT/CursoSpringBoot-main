package webapp.escola_completo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor implements Serializable{

    @Id
    private String cpfProfessor;
    private String nomeProfessor;
    private String emailProfessor;
    private String materiaProfessor;
    private String senhaProfessor;

    public String getNomeProfessor() {
        return nomeProfessor;
    }
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
    public String getCpfProfessor() {
        return cpfProfessor;
    }
    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }
    public String getEmailProfessor() {
        return emailProfessor;
    }
    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }
    public String getMateriaProfessor() {
        return materiaProfessor;
    }
    public void setMateriaProfessor(String materiaProfessor) {
        this.materiaProfessor = materiaProfessor;
    }
    public String getSenhaProfessor() {
        return senhaProfessor;
    }
    public void setSenhaProfessor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }

    
}
