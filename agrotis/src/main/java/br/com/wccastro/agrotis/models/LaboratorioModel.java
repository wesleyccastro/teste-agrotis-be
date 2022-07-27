package br.com.wccastro.agrotis.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_LABORATORIO")
public class LaboratorioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
