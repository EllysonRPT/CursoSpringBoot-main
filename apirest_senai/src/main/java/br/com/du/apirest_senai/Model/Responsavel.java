package br.com.du.apirest_senai.Model;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Responsavel implements Serializable {
//atributos
    @Id
    private Long id;    
    private String nome;




}
