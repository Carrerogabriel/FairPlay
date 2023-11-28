package com.example.terca.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class UsuarioAcessos extends EntityId{


    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Pessoa pessoa;

   @Column(name = "data_acesso")
   private LocalDate dataAcesso;

   @Column(name = "tipo_chamada")
   private  String tipoChamada;

    public Pessoa getUsuario() {
        return pessoa;
    }

    public void setUsuario(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDate getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(LocalDate dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public String getTipoChamada() {
        return tipoChamada;
    }

    public void setTipoChamada(String tipoChamada) {
        this.tipoChamada = tipoChamada;
    }

    @Override
    public String toString() {
        return "UsuarioAcessos{" +
                "usuario=" + pessoa +
                ", dataAcesso=" + dataAcesso +
                ", tipoChamada='" + tipoChamada + '\'' +
                '}';
    }
}
