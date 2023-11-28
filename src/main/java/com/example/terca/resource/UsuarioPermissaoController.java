package com.example.terca.resource;


import com.example.terca.model.UsuarioPermissoes;
import com.example.terca.service.UsuarioPermissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/usuario/permissao")
public class UsuarioPermissaoController extends AbstractController {

    @Autowired
    private UsuarioPermissoesService serviceUsuarioPermissao;

    @PostMapping
    public ResponseEntity create(@RequestBody UsuarioPermissoes entity){
        UsuarioPermissoes save = serviceUsuarioPermissao.salvar(entity);
        return ResponseEntity.created(URI.create("/api/usuario/permissao/" + entity.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<UsuarioPermissoes> usuarioPermissoes =serviceUsuarioPermissao.buscaTodos();
        return ResponseEntity.ok(usuarioPermissoes);
    }

    @GetMapping("{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        UsuarioPermissoes busca = serviceUsuarioPermissao.buscaPorId(id);
        return  ResponseEntity.ok(busca);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceUsuarioPermissao.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody UsuarioPermissoes entity){
        UsuarioPermissoes alterado = serviceUsuarioPermissao.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
