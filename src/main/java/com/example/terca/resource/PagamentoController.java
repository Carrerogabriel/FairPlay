package com.example.terca.resource;


import com.example.terca.model.Pagamento;
import com.example.terca.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController extends AbstractController{

    @Autowired
    private PagamentoService servicePagamento;

    @PostMapping("/salvar")
    public ResponseEntity create(@RequestBody Pagamento entity){
        Pagamento save = servicePagamento.salvar(entity);
        return ResponseEntity.created(URI.create("/api/pagamento/" + entity.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Pagamento> pagamento =servicePagamento.buscaTodos();
        return ResponseEntity.ok(pagamento);
    }

    @GetMapping("{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Pagamento produto = servicePagamento.buscaPorId(id);
        return  ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        servicePagamento.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Pagamento entity){
        Pagamento alterado = servicePagamento.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
