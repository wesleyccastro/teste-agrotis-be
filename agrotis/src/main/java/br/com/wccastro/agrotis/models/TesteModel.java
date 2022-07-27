package br.com.wccastro.agrotis.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TESTE")
public class TesteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    @ManyToOne
    @JoinColumn(name = "propriedade_id", nullable= false)
    private PropriedadeModel infosPropriedade;
    private String cnpj;
    @ManyToOne
    @JoinColumn(name = "laboratorio_id", nullable= false)
    private LaboratorioModel laboratorio;
    private String observacoes;

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

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public PropriedadeModel getInfosPropriedade() {
        return infosPropriedade;
    }

    public void setInfosPropriedade(PropriedadeModel infosPropriedade) {
        this.infosPropriedade = infosPropriedade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LaboratorioModel getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioModel laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
