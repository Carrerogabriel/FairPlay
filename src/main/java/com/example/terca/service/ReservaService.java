package com.example.terca.service;



import com.example.terca.enterprise.ValidationException;
import com.example.terca.model.Pessoa;
import com.example.terca.model.Quadra;
import com.example.terca.model.Reserva;
import com.example.terca.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repositorioReserva;

    public Reserva salvar(Reserva entity) {
        return repositorioReserva.save(entity);
    }

    public List<Reserva> buscaTodos() {return repositorioReserva.findAll();}

    public Reserva buscaPorId(Long id){return (Reserva) repositorioReserva.findById(id).orElse(null);}


    public Reserva alterar(Long id, Reserva alterado) {
        Optional<Reserva> encontrado = repositorioReserva.findById(id);
        if (encontrado.isPresent()) {
            Reserva reserva = encontrado.get();
            reserva.setUsuario(alterado.getUsuario());
            reserva.setDuracao(alterado.getDuracao());
            reserva.setPreco(alterado.getPreco());
            reserva.setStatus(alterado.getStatus());
            reserva.setQuadra(alterado.getQuadra());
            return (Reserva) repositorioReserva.save(reserva);
        }
        return null;
    }
    public void remover(Long id) {
        repositorioReserva.deleteById(id);
    }
}
