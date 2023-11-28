package com.example.terca.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Pessoa extends EntityId{

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", nullable = true)
    @NotBlank(message = "Campo Nao Informado")
    @CPF(message = "Campo Invalido")
    private String cpf;

    @Column(name = "email")
    @NotBlank(message = "Campo Nao Informado")
    @Email(message = "Campo Invalido")
    private String email;

    @Column(name = "tipo")
    @Min(value = 1980)
    @Max(value = 2004)
    private Integer anoNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
}
