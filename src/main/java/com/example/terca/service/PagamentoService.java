package com.example.terca.service;



import com.example.terca.model.Pagamento;
import com.example.terca.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repositorioPagamento;

    public Pagamento salvar(Pagamento entity) {

        return repositorioPagamento.save(entity);
    }

    public List<Pagamento> buscaTodos() {
        return repositorioPagamento.findAll();
    }

    public Pagamento buscaPorId(Long id) {
        return repositorioPagamento.findById(id).orElse(null);
    }

    public Pagamento alterar(Long id, Pagamento alterado) {
        Optional<Pagamento> encontrado = repositorioPagamento.findById(id);
        if(encontrado.isPresent()){
            Pagamento pagamento = encontrado.get();
            pagamento.setMetodoPagamento(alterado.getMetodoPagamento());
            pagamento.setReserva(alterado.getReserva());
            pagamento.setStatus(alterado.getStatus());
            pagamento.setValor(alterado.getValor());
            pagamento.setDataHora(alterado.getDataHora());
            return repositorioPagamento.save(pagamento);
        }
        return null;
    }

    public void remover(Long id) {
        repositorioPagamento.deleteById(id);
    }
}
