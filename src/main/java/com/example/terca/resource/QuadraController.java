package com.example.terca.resource;


import com.example.terca.model.Quadra;
import com.example.terca.service.QuadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/quadra")
public class QuadraController extends AbstractController{
    @Autowired
    private QuadraService serviceQuadra;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Quadra quadra){
        Quadra save = serviceQuadra.salvar(quadra);
        return ResponseEntity.created(URI.create("/quadra/salvar" + quadra.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Quadra> quadras = serviceQuadra.buscaTodos();
        return ResponseEntity.ok(quadras);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceQuadra.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Quadra entity){
        Quadra alterado = serviceQuadra.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }


}

