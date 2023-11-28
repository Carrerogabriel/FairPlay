package com.example.terca.resource;

import com.example.terca.model.Quadra;
import com.example.terca.model.Reserva;
import com.example.terca.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController extends AbstractController{

    @Autowired
    private ReservaService serviceReserva;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Reserva reserva){
        Reserva save = serviceReserva.salvar(reserva);
        return ResponseEntity.created(URI.create("/reserva/salvar" + reserva.getId())).body(save);
    }


    @GetMapping
    public  ResponseEntity findAll() {
        List<Reserva> reservas = serviceReserva.buscaTodos();
        return ResponseEntity.ok(reservas);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Reserva reservas = serviceReserva.buscaPorId(id);
        return ResponseEntity.ok().body(reservas);
    }



    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceReserva.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Reserva entity){
        Reserva alterado = serviceReserva.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
