package com.example.terca.service;



import com.example.terca.enterprise.ValidationException;
import com.example.terca.model.Quadra;
import com.example.terca.model.Reserva;
import com.example.terca.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuadraService {
    @Autowired
    private QuadraRepository repositorioQuadra;

    public Quadra salvar(Quadra entity) {
        return repositorioQuadra.save(entity);
    }

    public List<Quadra> buscaTodos() {
        return repositorioQuadra.findAll();
    }

    public Quadra buscaPorId(Long id) {
        return repositorioQuadra.findById(id).orElse(null);
    }
    public Quadra alterarStatus(Long id, String novoStatus) {
        Quadra quadra = buscaPorId(id);

        quadra.setStatus(novoStatus);
        return repositorioQuadra.save(quadra);
    }




    public Quadra alterar(Long id, Quadra alterado) {
        Optional<Quadra> encontrado = repositorioQuadra.findById(id);
        if(encontrado.isPresent()){
            Quadra quadra = encontrado.get();
            quadra.setCapacidade(alterado.getCapacidade());
            quadra.setNome(alterado.getNome());
            quadra.setHistorico(alterado.getHistorico());
            quadra.setTipoDeEsporte(alterado.getTipoDeEsporte());
            return repositorioQuadra.save(quadra);
        }
        return null;
    }

    public void remover(Long id) {
        repositorioQuadra.deleteById(id);
    }




}
