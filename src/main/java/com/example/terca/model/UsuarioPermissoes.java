package com.example.terca.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UsuarioPermissoes extends EntityId {


    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "reserva", nullable = false)
    private Reserva reserva;

    @Column(name = "nivel", nullable = false)
    private String nivel;

    public Pessoa getUsuario() {
        return pessoa;
    }

    public void setUsuario(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "UsuarioPermissoes{" +
                "usuario=" + pessoa +
                ", reserva=" + reserva +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
