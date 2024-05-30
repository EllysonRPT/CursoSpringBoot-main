package br.com.du.apirest_senai.Model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class AtivoPatrimonial implements Serializable {
    //atributos
    @Id
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_ambiente")
    private Ambiente ambiente;
    
}
