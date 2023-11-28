package com.example.terca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reserva extends EntityId{

    @ManyToOne
    @JoinColumn(name = "Usuario", nullable = false)
    private Pessoa pessoa;


    @ManyToOne
    @JoinColumn(name = "Quadra", nullable = false)
    private Quadra quadra;


    @Column(name = "data_hora", nullable = false)
    private LocalDate dataHora;

    @Column(name = "duracao", nullable = false)
    private Integer duracao;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "status", nullable = false)
    private String status;

    public Pessoa getUsuario() {
        return pessoa;
    }

    public void setUsuario(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    public Quadra getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + pessoa +
                ", quadra=" + quadra +
                ", dataHora='" + dataHora + '\'' +
                ", duracao=" + duracao +
                ", preco=" + preco +
                ", status='" + status + '\'' +
                '}';
    }
}
