package com.example.terca.service;

import com.example.terca.enterprise.ValidationException;
import com.example.terca.model.Pessoa;
import com.example.terca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorioPessoa;

    public Pessoa salvar(Pessoa entity) {

        if (entity.getNome().length() <3){
            throw new ValidationException("O nome deve ter mais que 3 caracter!");
        }


        if (repositorioPessoa.findByNome(entity.getNome()) != null){
            throw new ValidationException("ja existe um cliente com essas informações");
        }

        if (entity.getEmail() == null || entity.getEmail().isEmpty()) {
            throw new ValidationException("O email não pode estar vazio!");
        }



        return (Pessoa) repositorioPessoa.save(entity);
    }
    public List<Pessoa> buscaTodos() {return  repositorioPessoa.findAll();}

    public Pessoa buscaPorId(Long id){
        return (Pessoa) repositorioPessoa.findById(id).orElse(null);
    }

    public Pessoa alterar(Long id, Pessoa alterado) {
        Optional<Pessoa> encontrado = repositorioPessoa.findById(id);
        if ((encontrado.isPresent())){

            Pessoa pessoa = encontrado.get();
           pessoa.setEmail(alterado.getEmail());
           pessoa.setNome(alterado.getNome());

            return repositorioPessoa.save(pessoa);
        }
        return null;
    }
    public void remover(Long id) {repositorioPessoa.deleteById(id);}
}
