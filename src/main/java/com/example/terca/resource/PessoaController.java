package com.example.terca.resource;

import com.example.terca.model.Pessoa;
import com.example.terca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
public class PessoaController   {

    @Autowired
    private PessoaService servicePessoa;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody @Valid Pessoa pessoa){
        Pessoa save = servicePessoa.salvar(pessoa);
        return ResponseEntity.created(URI.create("/usuario/salvar" + pessoa.getId())).body(save);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> HandValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Pessoa> pessoa = servicePessoa.buscaTodos();
        return ResponseEntity.ok(pessoa);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Pessoa pessoa = servicePessoa.buscaPorId(id);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        servicePessoa.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Pessoa entity){
        Pessoa alterado = servicePessoa.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
