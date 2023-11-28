package com.example.terca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quadra extends EntityId{


    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo_esporte", nullable = false)
    private String tipoDeEsporte;

    @Column(name = "capacidade", nullable = false)
    private Integer capacidade;

    @Column(name = "historico", nullable = false)
    private String historico;
    @Column(name = "status", nullable = false)
    private String status;

    public  Quadra(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeEsporte() {
        return tipoDeEsporte;
    }

    public void setTipoDeEsporte(String tipoDeEsporte) {
        this.tipoDeEsporte = tipoDeEsporte;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }




    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Override
    public String toString() {
        return "Quadra{" +
                "nome='" + nome + '\'' +
                ", tipoDeEsporte='" + tipoDeEsporte + '\'' +
                ", capacidade=" + capacidade +
                ", historico='" + historico + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
