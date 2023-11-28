package com.example.terca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento extends EntityId
{
    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;
    @Column(name = "metodo_pagamento", nullable = false)
    private String metodoPagamento;
    @Column(name = "valor", nullable = false)
    private Double valor;
    @Column(name = "data_hora", nullable = false)
    private String dataHora;
    @Column(name = "status", nullable = false)
    private String status;

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "reserva=" + reserva +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", valor=" + valor +
                ", dataHora='" + dataHora + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
